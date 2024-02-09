package dev.kush.productcategory.config;

import dev.kush.productcategory.model.Category;
import dev.kush.productcategory.model.Product;
import dev.kush.productcategory.repository.CategoryRepository;
import dev.kush.productcategory.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SampleData {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository, CategoryRepository categoryRepository){
        return args -> {
            Category category = new Category("electric","all electric items");

            Product product1 = new Product("nothing 1",25000.0,"good design",category);

            Product product2 = new Product("nothing 2",35000.0,"good design",category);

            productRepository.saveAll(List.of(product1,product2));
        };
    }
}
