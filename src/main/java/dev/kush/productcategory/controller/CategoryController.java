package dev.kush.productcategory.controller;

import dev.kush.productcategory.model.Category;
import dev.kush.productcategory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    private List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/get/{categoryId}")
    private Category getCategoryById(@PathVariable Long categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    @PostMapping("/add")
    private Category addCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("/delete/{categoryId}")
    private Category deleteCategoryById(@PathVariable Long categoryId){
        return categoryService.deleteCategoryById(categoryId);
    }





}
