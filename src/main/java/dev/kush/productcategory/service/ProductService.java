package dev.kush.productcategory.service;


import dev.kush.productcategory.dto.ProductDto;
import dev.kush.productcategory.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long productId);

    Product saveProduct(ProductDto productDto);

    Product deleteProductById(Long productId);
    List<Product> findProductsByCategoryName(String categoryName);

}
