package com.sanskar.ecommerce.product.service;

import com.sanskar.ecommerce.product.entity.ProductCategoryMember;
import com.sanskar.ecommerce.product.repository.ProductCategoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductCategoryMemberService {
    private final ProductCategoryMemberRepository productCategoryMemberRepository;

    public List<ProductCategoryMember> createProductCategoryMembers(List<ProductCategoryMember> productCategoryMembers) {
        return productCategoryMemberRepository.saveAll(productCategoryMembers);
    }
}
