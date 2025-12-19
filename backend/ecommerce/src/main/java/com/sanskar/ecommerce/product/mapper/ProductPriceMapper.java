package com.sanskar.ecommerce.product.mapper;

import com.sanskar.ecommerce.product.dto.ProductPriceResponse;
import com.sanskar.ecommerce.product.entity.ProductPrice;
import org.springframework.stereotype.Component;

@Component
public class ProductPriceMapper {
    public ProductPriceResponse toProductPriceResponse(ProductPrice productPrice) {
       return new ProductPriceResponse(
           productPrice.getPriceType().getId(),
           productPrice.getCurrencyUomId(),
           productPrice.getPrice(),
           productPrice.getFromDate(),
           productPrice.getThruDate()
       );
    }
}
