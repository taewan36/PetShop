package com.taewan.shop.search;

import com.taewan.shop.domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderSearch {
    private String memberName;
    private OrderStatus orderStatus;
}
