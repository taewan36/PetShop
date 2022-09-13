package com.taewan.shop.service;

import com.taewan.shop.repository.OrderItemRepository;
import com.taewan.shop.domain.OrderItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItem findById(Long id){
        return orderItemRepository.findOrderItemById(id).orElseThrow(() -> new IllegalStateException("id로 OrderItem 을 찾을수 없습니다."));
    }


}
