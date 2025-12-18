package com.sanskar.ecommerce.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
public class ProductPriceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "priceType")
    private List<ProductPrice> productPrices;
}
