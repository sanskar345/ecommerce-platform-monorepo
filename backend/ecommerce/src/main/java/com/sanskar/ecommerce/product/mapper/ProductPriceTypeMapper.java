package com.sanskar.ecommerce.product.mapper;

import com.sanskar.ecommerce.product.dto.ProductPriceTypeResponse;
import com.sanskar.ecommerce.product.entity.ProductPriceType;
import org.springframework.stereotype.Component;

@Component
public class ProductPriceTypeMapper {
    public ProductPriceTypeResponse toProductPriceTypeResponse(ProductPriceType productPriceType) {
        return new ProductPriceTypeResponse(
            productPriceType.getId(),
            productPriceType.getDescription()
        );
    }
}
