package com.sanskar.ecommerce.inventory.entity;

import com.sanskar.ecommerce.product.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private int quantityOnHandTotal;
    private int availableToPromiseTotal;
}
