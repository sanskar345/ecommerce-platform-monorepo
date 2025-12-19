package com.sanskar.ecommerce.product.controller;

import com.sanskar.ecommerce.product.dto.ProductPriceTypeRequest;
import com.sanskar.ecommerce.product.dto.ProductPriceTypeResponse;
import com.sanskar.ecommerce.product.entity.ProductPriceType;
import com.sanskar.ecommerce.product.mapper.ProductPriceTypeMapper;
import com.sanskar.ecommerce.product.service.ProductPriceTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product-price-types")
public class ProductPriceTypeController {
    private final ProductPriceTypeService productPriceTypeService;
    private final ProductPriceTypeMapper productPriceTypeMapper;

    @PostMapping
    public ResponseEntity<ProductPriceTypeResponse> createProductPriceType(@Valid @RequestBody ProductPriceTypeRequest request) {
        ProductPriceType productPriceType = ProductPriceType.builder()
            .id(request.id())
            .description(request.description())
            .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(
            productPriceTypeMapper.toProductPriceTypeResponse(
                productPriceTypeService.createProductPriceType(
                    productPriceType
                )
            )
        );
    }
}
