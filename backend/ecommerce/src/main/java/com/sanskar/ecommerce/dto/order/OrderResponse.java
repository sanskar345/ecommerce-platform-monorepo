package com.sanskar.ecommerce.dto.order;

import java.time.LocalDate;
import java.util.List;

public record OrderResponse(
        Long orderId,
        String customerName,
        String email,
        String status,
        LocalDate orderDate,
        List<OrderItemResponse> items
) {
}