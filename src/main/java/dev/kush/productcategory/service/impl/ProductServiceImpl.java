package dev.kush.productcategory.service.impl;

import dev.kush.productcategory.exception.ItemNotFoundException;
import dev.kush.productcategory.model.Product;
import dev.kush.productcategory.repository.ProductRepository;
import dev.kush.productcategory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


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

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product deleteProductById(Long productId) {
        Product product = findProductById(productId);

        productRepository.delete(product);
        return product;
    }
}
