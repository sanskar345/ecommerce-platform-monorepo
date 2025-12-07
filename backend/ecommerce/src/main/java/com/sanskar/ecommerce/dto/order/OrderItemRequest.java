package com.sanskar.ecommerce.dto.order;

public record OrderItemRequest(
        Long productId,
        int quantity
) {}