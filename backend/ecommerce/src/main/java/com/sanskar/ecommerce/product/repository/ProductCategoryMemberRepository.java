package com.sanskar.ecommerce.product.repository;

import com.sanskar.ecommerce.product.entity.ProductCategoryMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryMemberRepository extends JpaRepository<ProductCategoryMember, Long> {
}
