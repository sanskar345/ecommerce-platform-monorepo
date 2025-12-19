package com.sanskar.ecommerce.product.repository;

import com.sanskar.ecommerce.product.entity.ProductPriceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPriceTypeRepository extends JpaRepository<ProductPriceType, String> {
}
