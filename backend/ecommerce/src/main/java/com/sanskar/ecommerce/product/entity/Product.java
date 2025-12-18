package com.sanskar.ecommerce.product.entity;

import com.sanskar.ecommerce.inventory.entity.InventoryItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String brandName;
    private String internalName;
    private String description;
    private LocalDate introductionDate;
    private LocalDate salesDiscontinuationDate;

    @OneToMany(mappedBy = "product")
    private List<ProductCategoryMember> productCategoryMemberships;

    @OneToMany(mappedBy = "product")
    private List<ProductPrice> prices;

    @OneToOne(mappedBy = "product")
    private InventoryItem inventory;
}