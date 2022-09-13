package com.taewan.shop.repository;

import com.taewan.shop.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    public Optional<Cart> findCartById(Long id);

}
