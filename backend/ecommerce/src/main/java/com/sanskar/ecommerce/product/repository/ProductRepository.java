package com.sanskar.ecommerce.product.repository;

import com.sanskar.ecommerce.product.entity.Product;
import com.sanskar.ecommerce.product.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("""
        SELECT pp
        FROM ProductPrice pp
        JOIN FETCH pp.priceType
        WHERE pp.product.id = :productId
    """)
    List<ProductPrice> findProductPricesByProductIdWithPriceType(@Param("productId") Long productId);
}
