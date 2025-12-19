package com.sanskar.ecommerce.product.mapper;

import com.sanskar.ecommerce.product.dto.ProductResponse;
import com.sanskar.ecommerce.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductMapper {
    private final ProductPriceMapper productPriceMapper;

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getProductName(),
            product.getBrandName(),
            product.getPrices().stream().map(productPriceMapper::toProductPriceResponse).toList(),
            product.getInventory().getAvailableToPromiseTotal() > 0,
            product.getInventory().getAvailableToPromiseTotal()
        );
    }
}
