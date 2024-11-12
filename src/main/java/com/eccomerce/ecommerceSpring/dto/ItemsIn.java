package com.eccomerce.ecommerceSpring.dto;

import jakarta.validation.constraints.*;

import java.net.URL;

public record ItemsIn (
        @NotNull(message = "Description cannot be null")
        @Size(min = 10, max = 255, message = "Description must be between 10 and 255 characters")
        String description,

        @NotNull(message = "Name cannot be null")
        @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
        String name,

        @NotNull(message = "Price cannot be null")
        @DecimalMin(value = "0.00", inclusive = true, message = "Price must be greater than 0")
        Double price,

        @NotNull(message = "Gender cannot be null")
        @Pattern(regexp = "^(Male|Female|Unisex)$", message = "Gender must be Male, Female, or Unisex")
        String gender,

        @NotNull(message = "Image URL cannot be null")
        String imageUrl,

        @NotNull(message = "Category cannot be null")
        @Size(min = 3, message = "Category must be at least 3 characters long")
        String category
) {
}

