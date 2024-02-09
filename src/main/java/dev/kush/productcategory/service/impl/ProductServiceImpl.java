package dev.kush.productcategory.service.impl;

import dev.kush.productcategory.dto.ProductDto;
import dev.kush.productcategory.exception.ItemNotFoundException;
import dev.kush.productcategory.model.Category;
import dev.kush.productcategory.model.Product;
import dev.kush.productcategory.repository.CategoryRepository;
import dev.kush.productcategory.repository.ProductRepository;
import dev.kush.productcategory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        return findProductById(productId);
    }

    private Product findProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(
                () -> new ItemNotFoundException("Product not found")
        );
    }

    private Category findCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(
                () -> new ItemNotFoundException("Category not found with id: " + categoryId)
        );
    }

    @Override
    public Product saveProduct(ProductDto productDto) {
        Category category = findCategoryById(productDto.categoryId());

        return new Product(productDto.productName(), productDto.price(),
                productDto.description(), category);
    }

    @Override
    public Product deleteProductById(Long productId) {
        Product product = findProductById(productId);

        productRepository.delete(product);
        return product;
    }

    @Override
    public List<Product> findProductsByCategoryName(String categoryName) {
        Category category = categoryRepository.findByCategoryName(categoryName).orElseThrow(
                () -> new ItemNotFoundException("Category not found with name: " + categoryName)
        );

        return productRepository.findAllByCategoryId(category.getCategoryId());
    }
}
