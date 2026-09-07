package com.ecommerce.api.dto;


import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDto {
    @NotBlank(message = "Product name is required")
    @Size(min = 2, max = 150, message = "Name must be between 2 and 150 characters")
    private String name;

    private String description;

    @NotNull(message = "Price is required!")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0!")
    private BigDecimal price;

    @NotNull(message = "Stock quantity is required!")
    @Min(value = 0, message = "Stock cannot be negative!")
    private Integer stockQuantity;

    @NotNull(message = "Category ID is required!")
    private Long categoryId;
}
