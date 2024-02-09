package dev.kush.productcategory.repository;

import dev.kush.productcategory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


    @Query(value = "select * from product p where p.category_id = ?1",nativeQuery = true)
    List<Product> findAllByCategoryId(Long categoryId);
}

