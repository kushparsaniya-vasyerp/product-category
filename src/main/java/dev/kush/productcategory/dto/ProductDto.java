package dev.kush.productcategory.dto;

public record ProductDto(
        String productName,
        double price,
        String description,
        Long categoryId
) {
}
