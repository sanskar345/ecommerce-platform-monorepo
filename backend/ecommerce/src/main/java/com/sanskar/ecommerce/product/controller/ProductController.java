package com.sanskar.ecommerce.product.controller;

import com.sanskar.ecommerce.product.dto.ProductResponse;
import com.sanskar.ecommerce.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable String id) {
        return productService.getProduct(Long.parseLong(id))
                .map(productService::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponse>> getProducts() {
        List<ProductResponse> products = productService.getProducts().stream()
                .map(productService::toResponse)
                .toList();
        return ResponseEntity.ok(products);
    }
}
