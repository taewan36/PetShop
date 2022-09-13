package com.taewan.shop.repository;

import com.taewan.shop.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
    public Optional<OrderItem> findOrderItemById(Long id);

}
