package com.sanskar.ecommerce.product.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record ProductCreateRequest(
    @NotBlank(message = "Product name is required")
    String productName,

    @NotBlank(message = "brandName name is required")
    String brandName,

    @NotBlank(message = "internalName name is required")
    String internalName,

    @NotBlank(message = "description name is required")
    String description,

    @NotNull(message = "introductionDate name is required")
    LocalDate introductionDate,

    LocalDate salesDiscontinuationDate,

    List<@Valid ProductPriceRequest> productPrices
) {}
