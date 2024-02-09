package dev.kush.productcategory.controller;

import dev.kush.productcategory.model.Product;
import dev.kush.productcategory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    private List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/get/{productId}")
    private Product getProductById(@PathVariable Long productId){
        return productService.getProductById(productId);
    }

    @PostMapping("/add")
    private Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/delete/{productId}")
    private Product deleteProduct(@PathVariable Long productId){
        return productService.deleteProductById(productId);
    }

}
