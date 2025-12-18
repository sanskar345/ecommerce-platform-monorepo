package com.sanskar.ecommerce.auth.dto;

public record RegisterRequest(
        String email,
        String password,
        String name
){};
