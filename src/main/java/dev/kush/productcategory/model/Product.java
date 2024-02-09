package dev.kush.productcategory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
    @Id  @GeneratedValue
    private Long productId;

    private String productName;
    private double price;
    private String description;


    @ManyToOne(cascade = {DETACH,MERGE,PERSIST,REFRESH})
    @JoinColumn(name="category_id")
    private Category category;

    public Product(String productName, double price, String description, Category category) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.category = category;
    }
}
