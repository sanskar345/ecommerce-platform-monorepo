package com.sanskar.ecommerce.dto.product;
public record ProductResponse(
        Long id,
        String name,
        String brand,
        Integer price,
        Boolean productAvailable,
        Integer stockQuantity
) {}
