package dev.kush.productcategory.service.impl;

import dev.kush.productcategory.exception.ItemNotFoundException;
import dev.kush.productcategory.model.Category;
import dev.kush.productcategory.repository.CategoryRepository;
import dev.kush.productcategory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return findCategoryById(categoryId);
    }

    private Category findCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(
                () -> new ItemNotFoundException("Category not found with id: " + categoryId)
        );
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category deleteCategoryById(Long categoryId) {
        Category category = findCategoryById(categoryId);

        categoryRepository.delete(category);
        return category;
    }


}
