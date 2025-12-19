package com.sanskar.ecommerce.auth.controller;

import com.sanskar.ecommerce.auth.dto.LoginRequest;
import com.sanskar.ecommerce.auth.dto.LoginResponse;
import com.sanskar.ecommerce.auth.dto.RegisterRequest;
import com.sanskar.ecommerce.auth.dto.RegisterResponse;
import com.sanskar.ecommerce.auth.mapper.AuthMapper;
import com.sanskar.ecommerce.auth.service.JwtService;
import com.sanskar.ecommerce.user.entity.User;
import com.sanskar.ecommerce.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth/")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AuthMapper authMapper;

    @PostMapping("register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            authMapper.toRegisterResponse(userService.createUser(
                request.name(),
                request.email(),
                request.password()
            ))
        );
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest user){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.email(), user.password()));

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
            new LoginResponse(
                jwtService.generateToken(user.email()),
                "Bearer"
            )
        );
    }
}
