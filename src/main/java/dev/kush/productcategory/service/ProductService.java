package dev.kush.productcategory.service;


import dev.kush.productcategory.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long productId);

    Product saveProduct(Product product);

    Product deleteProductById(Long productId);
}
