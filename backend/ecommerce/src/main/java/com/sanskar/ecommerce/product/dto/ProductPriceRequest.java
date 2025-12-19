package com.sanskar.ecommerce.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProductPriceRequest(
    @NotBlank(message = "currencyUomId is required")
    String currencyUomId,

    @NotNull(message = "price is required")
    BigDecimal price,

    @NotNull(message = "fromDate is required")
    LocalDate fromDate,

    @NotNull(message = "thruDate is required")
    LocalDate thruDate,

    @NotBlank(message = "productPriceTypeId is required")
    String productPriceTypeId
) {}
