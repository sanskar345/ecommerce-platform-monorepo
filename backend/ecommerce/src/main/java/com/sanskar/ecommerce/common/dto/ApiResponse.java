package com.sanskar.ecommerce.common.dto;

public record ApiResponse<T>(
    boolean success,
    String message,
    T data
) {}
