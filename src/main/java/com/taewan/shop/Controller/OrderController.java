package com.taewan.shop.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taewan.shop.domain.Cart;
import com.taewan.shop.domain.Member;
import com.taewan.shop.domain.Order;
import com.taewan.shop.domain.OrderStatus;
import com.taewan.shop.dto.OrderDto;
import com.taewan.shop.form.OrderForm;
import com.taewan.shop.form.PayForm;
import com.taewan.shop.resolver.Login;
import com.taewan.shop.resolver.SessionCart;
import com.taewan.shop.search.OrderSearch;
import com.taewan.shop.service.CategoryService;
import com.taewan.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;
    private final ObjectMapper objectMapper;


    //오더 상세 페이지
    @GetMapping("content/{orderId}")
    public String getOrderContent(@PathVariable Long orderId, @Login Member member, @SessionCart Cart cart, Model model) {
        if (member != null) {
            model.addAttribute("username", member.getUsername());
            log.info("멤버이름 : {}", member.getUsername());
        }

        //기본적인 헤더 필요한 정보 주입 (카테고리, 카트사이즈)
        model.addAttribute("category", CategoryService.category);
        model.addAttribute("cartSize", (cart == null) ? 0 : cart.getSize());

        OrderDto orderDto = orderService.getOrderContent(orderId, member);

        model.addAttribute("orderDto", orderDto);


        return "order/orderContent";
    }

    //오더 캔슬
    @GetMapping("cancel/{orderId}")
    public String cancelOrder(@PathVariable Long orderId, @Login Member member) {

        log.info("오더 캔슬");
        orderService.cancel(orderId, member);

        return "redirect:/order/list";
    }

    //생성한 오더 결제 전 페이지
    @GetMapping("{orderId}")
    public String orderBeforePay(@SessionCart Cart cart, Model model, @Login Member member, @PathVariable Long orderId) throws IllegalAccessException {
        if (member != null) {
            model.addAttribute("username", member.getUsername());
            log.info("멤버이름 : {}", member.getUsername());
        }
        //기본적인 헤더 필요한 정보 주입 (카테고리, 카트사이즈)
        model.addAttribute("category", CategoryService.category);
        model.addAttribute("cartSize", (cart == null) ? 0 : cart.getSize());

        //오더아이디로 불러오기
        Order findOrder = orderService.findOrderById(orderId);

        //오더 상태체크
        if (findOrder.getOrderStatus() != OrderStatus.PRE_ORDER) {
            throw new IllegalAccessException("결제 전 오더만 결제할 수 있습니다.");
        }

        //오더 가격
        int totalPrice = findOrder.getTotalPrice();
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("orderId", orderId);
        model.addAttribute("orderUuid", findOrder.getUuid());


        return "order/order";
    }


    // 오더 결제 (결제과정 생략한 결제)
    @PostMapping("pay")
    public String payOrder(@SessionCart Cart cart, Model model, @Login Member member, @ModelAttribute PayForm payForm) {
        if (member != null) {
            model.addAttribute("username", member.getUsername());
        }
        //기본적인 헤더 필요한 정보 주입 (카테고리, 카트사이즈)
        model.addAttribute("category", CategoryService.category);
        model.addAttribute("cartSize", (cart == null) ? 0 : cart.getSize());

        Long orderId = payForm.getOrderId();
        orderService.payOrder(orderId, payForm);


        return "redirect:/order/list";
    }

    //결제 검증 프로세스
    @PostMapping("payCheck")
    @ResponseBody
    public Object payOrderCheck(@RequestBody String request) throws JsonProcessingException {


        Map<String, Object> message = orderService.payCheckProcess(request);


        return message;
    }


    //카트에서 오더 생성
    @PostMapping("new")
    @ResponseBody
    public Object order(@Login Member member, @RequestBody List<OrderForm> orderForms, HttpSession session, @SessionCart Cart cart) {

        Long orderId;

        //로그인 상태체크
        if (member == null) {
            return makeErrorCode("NOT_LOGIN", "구매는 로그인이 필요합니다.");
        }

        //카트 체크크
        if (cart == null || cart.getOrderItems().size() == 0) {
            return makeErrorCode("NULL", "카트가 비었습니다");
        }

        try {
            orderId = orderService.makeOrder(orderForms, member, session);
        } catch (IllegalStateException e) {
            return makeErrorCode("IllegalStateException", e.getMessage());
        }

        Map<String, Object> successCode = new HashMap<>();
        successCode.put("code", "OK");
        successCode.put("message", "오더");
        successCode.put("orderId", orderId);


        return successCode;
    }

    //주문목록 뽑기
    @GetMapping("list")
    public String orderList(@Login Member member, Model model, @SessionCart Cart cart, @ModelAttribute OrderSearch orderSearch) {

        //헤더
        model.addAttribute("category", CategoryService.category);
        model.addAttribute("cartSize", (cart == null) ? 0 : cart.getSize());
        if (member != null) {
            model.addAttribute("username", member.getUsername());
        }

        List<OrderDto> orderDtos = orderService.findAllByMemberId(member);

        model.addAttribute("orderDto", orderDtos);

        return "order/orderList";

    }




    private Object makeErrorCode(String code, String message) {
        Map<String, Object> errorCode = new HashMap<String, Object>();
        errorCode.put("code", code);
        errorCode.put("message", message);

        return errorCode;
    }
}
