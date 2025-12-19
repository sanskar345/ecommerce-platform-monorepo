package com.sanskar.ecommerce.product.controller;

import com.sanskar.ecommerce.product.dto.ProductCreateRequest;
import com.sanskar.ecommerce.product.dto.ProductResponse;
import com.sanskar.ecommerce.product.entity.Product;
import com.sanskar.ecommerce.product.entity.ProductPrice;
import com.sanskar.ecommerce.product.mapper.ProductMapper;
import com.sanskar.ecommerce.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable String id) {
        return productService.getProduct(Long.parseLong(id))
                .map(productMapper::toProductResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductResponse>> getProducts() {
        List<ProductResponse> products = productService.getProducts().stream()
                .map(productMapper::toProductResponse)
                .toList();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/")
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductCreateRequest request) {
        ProductResponse productResponse= productMapper.toProductResponse(productService.createProduct(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }
}
