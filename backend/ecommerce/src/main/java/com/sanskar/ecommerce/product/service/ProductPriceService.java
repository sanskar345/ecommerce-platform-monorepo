package com.sanskar.ecommerce.product.service;

import com.sanskar.ecommerce.product.entity.ProductPrice;
import com.sanskar.ecommerce.product.repository.ProductPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductPriceService {
    private final ProductPriceRepository productPriceRepository;

    public List<ProductPrice> createProductPrice(List<ProductPrice> productPrices) {
        return productPriceRepository.saveAll(productPrices);
    }
}
