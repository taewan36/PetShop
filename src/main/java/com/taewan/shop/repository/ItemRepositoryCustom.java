package com.taewan.shop.repository;

import com.taewan.shop.Controller.search.ItemSearch;
import com.taewan.shop.dto.ItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryCustom{
    public Page<ItemDto> searchItem(ItemSearch itemSearch, Pageable pageable);

    public Page<ItemDto> searchItemWithCategory(ItemSearch itemSearch, Pageable pageable,Long categoryId);

}
