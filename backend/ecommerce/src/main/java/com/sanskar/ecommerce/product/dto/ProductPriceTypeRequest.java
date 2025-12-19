package com.sanskar.ecommerce.product.dto;

import jakarta.validation.constraints.NotBlank;

public record ProductPriceTypeRequest(
    @NotBlank(message = "id is required")
    String id,

    @NotBlank(message = "description is required")
    String description
) {
}
