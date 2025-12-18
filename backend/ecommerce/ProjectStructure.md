com.sanskar.ecommerce
├── EcommerceApplication.java
├── config
│   ├── security
│   │   ├── SecurityConfig.java
│   │   ├── JwtAuthFilter.java
│   │   └── JwtAuthenticationEntryPoint.java   (optional)
│   └── OpenApiConfig.java (optional)
├── auth
│   ├── controller
│   │   └── AuthController.java
│   ├── dto
│   │   ├── LoginRequest.java
│   │   ├── RegisterRequest.java
│   │   ├── AuthResponse.java     (token + user info)
│   │   └── ErrorResponse.java    (optional)
│   ├── service
│   │   ├── AuthService.java
│   │   └── JwtService.java
│   └── mapper
│       └── AuthMapper.java       (optional)
├── user
│   ├── entity
│   │   └── User.java
│   ├── repository
│   │   └── UserRepository.java
│   └── service
│       └── UserService.java
├── order
│   ├── controller
│   ├── dto
│   ├── entity
│   ├── repository
│   ├── service
│   └── mapper
└── common
├── exception
│   ├── GlobalExceptionHandler.java
│   └── ApiException.java
└── util
