package com.sanskar.ecommerce.auth.dto;

public record LoginResponse(
    String accessToken,
    String tokenType
) {}
