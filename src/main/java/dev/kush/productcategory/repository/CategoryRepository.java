package dev.kush.productcategory.repository;

import dev.kush.productcategory.model.Category;
import dev.kush.productcategory.model.CategoryName;
import dev.kush.productcategory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Product> findProductsByCategoryName(CategoryName categoryName);

}
