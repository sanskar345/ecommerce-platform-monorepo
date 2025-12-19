package com.sanskar.ecommerce.product.dto;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponse(
        Long id,
        String name,
        String brand,
        List<ProductPriceResponse> prices,
        Boolean productAvailable,
        Integer stockQuantity
) {}
