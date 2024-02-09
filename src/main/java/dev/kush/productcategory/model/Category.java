package dev.kush.productcategory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id  @GeneratedValue
    private Long categoryId;

    private String categoryName;
    private String description;



    public Category(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }
}
