package com.taewan.shop.repository;

import com.taewan.shop.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item,Long>, ItemRepositoryCustom{
    public Optional<Item> findById(Long id);

    public Page<Item> findAll(Pageable pageable);


}
