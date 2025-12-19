package com.sanskar.ecommerce.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductPrice {
    @EmbeddedId
    private ProductPriceId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @MapsId("productPriceTypeId")
    @JoinColumn(name = "product_price_type_id", nullable = false)
    private ProductPriceType priceType;

    private String currencyUomId;
    private BigDecimal price;
    private LocalDate fromDate;
    private LocalDate thruDate;
}
