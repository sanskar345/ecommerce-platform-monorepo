package com.sanskar.ecommerce.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryMember {
    @EmbeddedId
    private ProductCategoryMemberId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")              // FK column in this table
    private Product product;

    @ManyToOne
    @MapsId("productCategoryId")
    @JoinColumn(name = "product_category_id")     // FK column in this table
    private ProductCategory category;

    private LocalDate fromDate;
    private LocalDate thruDate;
}
