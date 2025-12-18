package com.sanskar.ecommerce.user.service;

import com.sanskar.ecommerce.auth.dto.RegisterRequest;
import com.sanskar.ecommerce.user.entity.User;
import com.sanskar.ecommerce.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public User createUser(String name, String email, String rawPassword) {
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists");
        }

        User newUser = User.builder()
                .name(name)
                .email(email)
                .password(encoder.encode(rawPassword))
                .build();

        return userRepository.save(newUser) ;
    }
}
