package com.sanskar.ecommerce.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Embeddable
public class ProductPriceId implements Serializable {
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_price_type_id", nullable = false)
    private String productPriceTypeId;
}
