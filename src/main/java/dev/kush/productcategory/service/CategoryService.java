package dev.kush.productcategory.service;

import dev.kush.productcategory.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long categoryId);

    Category saveCategory(Category category);

    Category deleteCategoryById(Long categoryId);


}
