package com.sanskar.ecommerce.auth.mapper;

import com.sanskar.ecommerce.auth.dto.RegisterResponse;
import com.sanskar.ecommerce.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {
    public RegisterResponse toRegisterResponse(User user) {
        return new RegisterResponse(
            user.getEmail(),
            user.getName()
        );
    }
}
