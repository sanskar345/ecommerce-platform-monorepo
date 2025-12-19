package com.sanskar.ecommerce.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(
        name = "product_price_type",
        uniqueConstraints = {
                @UniqueConstraint(name = "uc_type_name", columnNames = {"name"})
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductPriceType {
    @Id
    private String id;

    private String description;

    @OneToMany(mappedBy = "priceType")
    private List<ProductPrice> productPrices;
}
