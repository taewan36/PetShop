package com.taewan.shop.repository;

import com.taewan.shop.domain.Order;
import com.taewan.shop.domain.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    public Optional<Order> findOrderById(Long id);

    public Optional<Order> findOrderByUuid(String uuid);


    @Modifying(clearAutomatically = true)
    @Query(value = "update OrderItem o set o.cart.id = NULL where o.cart.id = :cartId")
    public void deleteOrdersByCartId(@Param("cartId")long cartId);

    public List<Order> findOrdersByMemberId(Long memberId);

    public List<Order> findOrdersByMemberIdOrderByIdDesc(Long memberId);

    public Page<Order> findOrdersByOrderStatus(OrderStatus orderStatus, Pageable pageable);

}
