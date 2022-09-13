package com.taewan.shop.form;

import com.taewan.shop.domain.Category;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Data
public class ItemForm {
    private String itemName;

    private int price;
    private int discountPrice;

    private int quantity;

    private int ratingStar;
    private Long categoryId;

    private List<Category> categories;

    private MultipartFile imageSource;
}
