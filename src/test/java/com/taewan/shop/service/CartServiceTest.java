package com.taewan.shop.service;

import com.taewan.shop.domain.Cart;
import com.taewan.shop.domain.Item;
import com.taewan.shop.domain.*;
import com.taewan.shop.dto.CartDto;
import com.taewan.shop.dto.OrderItemDto;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Rollback
class CartServiceTest {
    @Autowired
    private CartService cartService;
    @Autowired
    private ItemService itemService;


    Logger log = LoggerFactory.getLogger("CartServiceTest");

//    @Test
//    void saveOrderItemToCart() {
//
//        //given
//        Category test = new Category("test", 1L, null);
//        categoryRepository.save(test);
//
//        Item item1 = new Item(123, 123, 12, 2, new UploadFile("asd", "asd"), test, "어디로 가야하나");
//        itemRepository.save(item1);
//
//        List<Item> all = itemService.findAll();
//        Item item = all.get(0);
//
//        Cart cart = new Cart();
//        Long cartId = cartService.saveCart(cart);
//
//
//        //when
//        cartService.saveOrderItemToCart(cart, item.getId());
//
//
//        //then
//        Cart byId = cartService.findById(cartId);
//
////        log.info("{}", cartService.findAll().get(0));
////        log.info("{}", cartService.findAll().get(1));
//
//        assertThat(cartService.findAll().size()).isEqualTo(2);
//        assertThat(byId.getOrderItems().size()).isEqualTo(2);
//    }

    @Test
    @Transactional
    void makeCartDto(){
        //given
        List<Item> all = itemService.findAll();
        Item item = all.get(0);

        Cart cart = new Cart();
        Long cartId = cartService.saveCart(cart);
        Cart cart1 = cartService.findById(cartId);
        cart1.getOrderItems().stream()
                .forEach(orderItem -> {
                    orderItem.getItem();
                });


        //when
        cartService.saveOrderItemToCart(cart1, item.getId());

        CartDto cartDto = cartService.makeCartDto(cart1);

        List<OrderItemDto> orderItems = cartDto.getOrderItems();

        for (OrderItemDto orderItem : orderItems) {
            log.info("오더아이템 {}", orderItem.getItemName());
        }

        //then
        assertThat(orderItems.size()).isEqualTo(1);

    }
}