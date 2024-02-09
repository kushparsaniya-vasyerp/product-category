package dev.kush.productcategory.service;

import dev.kush.productcategory.model.Category;
import dev.kush.productcategory.model.CategoryName;
import dev.kush.productcategory.model.Product;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long categoryId);

    Category createCategory(Category category);

    Category deleteCategoryById(Long categoryId);

    List<Product> findProductsByCategoryName(CategoryName categoryName);

}
