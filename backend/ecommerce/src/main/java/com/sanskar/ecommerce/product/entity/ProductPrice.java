package com.sanskar.ecommerce.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"product_id", "product_price_type_id"}
        )
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // simple primary key

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "product_price_type_id", nullable = false)
    private ProductPriceType priceType;

    private String currencyUomId;
    private BigDecimal price;
    private String fromDate;
    private String thruDate;
}
