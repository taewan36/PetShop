package com.taewan.shop.Controller;


import com.taewan.shop.Controller.search.ItemSearch;
import com.taewan.shop.domain.Cart;
import com.taewan.shop.domain.Member;
import com.taewan.shop.dto.ItemDto;
import com.taewan.shop.resolver.Login;
import com.taewan.shop.resolver.SessionCart;
import com.taewan.shop.service.CategoryService;
import com.taewan.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("item")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("category/{categoryId}")
    public String categoryItems(Model model, @SessionCart Cart cart, @Login Member member, HttpServletRequest request,
                                @PageableDefault(size = 8) Pageable pageable, ItemSearch itemSearch, @PathVariable Long categoryId) {

        if (member != null) {
            model.addAttribute("username", member.getUsername());
        }

        Page<ItemDto> itemDtos = itemService.searchCategoryItems(itemSearch, pageable,categoryId);

        model.addAttribute("homeItemDto", itemDtos);
        model.addAttribute("category", CategoryService.category);
        model.addAttribute("cartSize", (cart == null) ? 0 : cart.getSize());
        model.addAttribute("categoryId", categoryId);


        return "item/itemAllWithCategory";


    }

    //모든 아이템 검색
    @GetMapping("all")
    public String itemAll(Model model, @SessionCart Cart cart, @Login Member member, HttpServletRequest request,
                          @PageableDefault(size = 8) Pageable pageable, @ModelAttribute ItemSearch itemSearch) {

        if (member != null) {
            model.addAttribute("username", member.getUsername());
        }



        Page<ItemDto> itemDtos = itemService.searchAllItem(itemSearch, pageable);

        model.addAttribute("homeItemDto", itemDtos);
        model.addAttribute("category", CategoryService.category);
        model.addAttribute("cartSize", (cart == null) ? 0 : cart.getSize());


        return "item/itemAll";

    }
}
