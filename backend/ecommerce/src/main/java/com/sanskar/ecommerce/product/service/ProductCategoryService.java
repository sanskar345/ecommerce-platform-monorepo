package com.sanskar.ecommerce.product.service;

import com.sanskar.ecommerce.product.entity.ProductCategory;
import com.sanskar.ecommerce.product.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> createProductCategories(List<ProductCategory> productCategories) {
        return productCategoryRepository.saveAll(productCategories);
    }
}
