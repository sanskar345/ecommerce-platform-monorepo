package com.sanskar.ecommerce.auth.dto;

public record LoginRequest(
        String email,
        String password
) {};
