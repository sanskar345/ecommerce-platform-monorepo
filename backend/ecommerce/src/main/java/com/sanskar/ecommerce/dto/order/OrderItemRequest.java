package com.sanskar.ecommerce.dto.order;

public record OrderItemRequest(
        int productId,
        int quantity
) {}