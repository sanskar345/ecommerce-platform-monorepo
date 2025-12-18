package com.sanskar.ecommerce.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(
        name = "product_category",
        uniqueConstraints = {
                @UniqueConstraint(name = "uc_category_name", columnNames = {"category_name"})
        }
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<ProductCategoryMember> products;
}