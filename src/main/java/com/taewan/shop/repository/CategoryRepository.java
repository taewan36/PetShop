package com.taewan.shop.repository;

import com.taewan.shop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    public Optional<Category> findCategoryByName(String name);


}
