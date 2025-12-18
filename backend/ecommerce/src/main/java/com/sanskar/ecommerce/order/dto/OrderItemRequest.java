package com.sanskar.ecommerce.order.dto;

public record OrderItemRequest(
        Long productId,
        int quantity
) {}