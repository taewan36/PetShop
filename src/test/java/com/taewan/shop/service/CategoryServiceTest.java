package com.taewan.shop.service;

import com.taewan.shop.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest

class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    Logger log = LoggerFactory.getLogger(CategoryServiceTest.class);


    @Test
    void testRootCategory() {
//        //given
//        List<Category> categoryEntities = createCategoryEntities();
//        List<Category> all = categoryRepository.findAll();
//       // log.info("all {}", all);
//
//       // assertThat(all).isEqualTo(categoryEntities);
//
//        //when
//        CategoryDto categoryRoot = categoryService.createCategoryRoot();
//        log.info("categoryRoot {}", categoryRoot.getParentId());
//
//        //then
//
//        //root
//        assertThat(categoryRoot.getSubCategories().size()).isEqualTo(2);
//
//        //sub1
//        assertThat(categoryRoot.getSubCategories().get(0).getSubCategories().size()).isEqualTo(2);
//
//        //sub2
//        assertThat(categoryRoot.getSubCategories().get(1).getSubCategories().size()).isEqualTo(2);

    }

//    private List<Category> createCategoryEntities() {
//        Category sub1 = new Category("SUB1"   ,1L, 0L);
//        Category sub2 = new Category("SUB2"   ,2L, 0L);
//        Category sub11 = new Category("SUB1-1",3L, 1L);
//        Category sub12 = new Category("SUB1-2",4L, 1L);
//        Category sub21 = new Category("SUB2-1",5L, 2L);
//        Category sub22 = new Category("SUB2-2",6L, 2L);
//
//        categoryRepository.save(sub1);
//        categoryRepository.save(sub2);
//        categoryRepository.save(sub11);
//        categoryRepository.save(sub12);
//        categoryRepository.save(sub21);
//        categoryRepository.save(sub22);
//
////        ReflectionTestUtils.setField(sub1, "id", 1L);
////        ReflectionTestUtils.setField(sub2, "id", 2L);
////        ReflectionTestUtils.setField(sub11, "id", 3L);
////        ReflectionTestUtils.setField(sub12, "id", 4L);
////        ReflectionTestUtils.setField(sub21, "id", 5L);
////        ReflectionTestUtils.setField(sub22, "id", 6L);
//
//        List<Category> categoryEntities = List.of(sub1, sub2, sub11, sub12, sub21, sub22);
//
//        return categoryEntities;
//
//    }
}