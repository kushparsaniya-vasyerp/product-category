package dev.kush.productcategory.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id  @GeneratedValue
    private Long categoryId;

    @Enumerated(EnumType.STRING)
    private CategoryName categoryName;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(CategoryName categoryName, String description, List<Product> products) {
        this.categoryName = categoryName;
        this.description = description;
        this.products = products;
    }

    public Category(CategoryName categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }
}
