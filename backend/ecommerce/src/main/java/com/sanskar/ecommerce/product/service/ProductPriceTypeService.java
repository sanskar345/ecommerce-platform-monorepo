package com.sanskar.ecommerce.product.service;

import com.sanskar.ecommerce.product.entity.ProductPriceType;
import com.sanskar.ecommerce.product.repository.ProductPriceTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductPriceTypeService {
    private final ProductPriceTypeRepository productPriceTypeRepository;

    public ProductPriceType createProductPriceType(ProductPriceType productPriceType) {
        return productPriceTypeRepository.save(productPriceType);
    }
}
