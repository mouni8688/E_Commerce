package com.shopsphere.shopsphere.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Getter
@Setter

public class ProductRequestDto {
    @NotBlank(message = "Product Name is required")
    private String name;

    @NotBlank(message = "Decription is required")
    private String description;

    @NotNull(message = "Price should not be empty")
    private BigDecimal price;

    @NotNull(message = "Stock is required")
    @PositiveOrZero(message="Stock can not be negative")
    private Integer stock;

    @NotBlank(message = "image is required")
    private String imageUrl;

    @NotNull(message = "category Id is required")
    private Long categoryId;

}
