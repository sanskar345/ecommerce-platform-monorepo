package com.sanskar.ecommerce.product.dto;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        String brand,
        BigDecimal price,
        Boolean productAvailable,
        Integer stockQuantity
) {}
