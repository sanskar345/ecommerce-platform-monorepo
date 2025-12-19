package com.sanskar.ecommerce.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Embeddable
public class ProductCategoryMemberId implements Serializable {
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_category_id", nullable = false)
    private Long productCategoryId;
}
