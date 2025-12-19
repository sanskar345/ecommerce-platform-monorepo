package com.sanskar.ecommerce.product.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProductPriceResponse (
    String priceType,
    String currencyUomId,
    BigDecimal price,
    LocalDate fromDate,
    LocalDate thruDate
) {}
