package com.sanskar.ecommerce.product.service;

import com.sanskar.ecommerce.product.dto.ProductCreateRequest;
import com.sanskar.ecommerce.product.dto.ProductResponse;
import com.sanskar.ecommerce.product.entity.Product;
import com.sanskar.ecommerce.product.entity.ProductPrice;
import com.sanskar.ecommerce.product.entity.ProductPriceType;
import com.sanskar.ecommerce.product.repository.ProductPriceTypeRepository;
import com.sanskar.ecommerce.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductPriceTypeRepository productPriceTypeRepository;

    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

//    public List<Product> createProducts(List<Product> products) {
//
//    }

    @Transactional
    public Product createProduct(ProductCreateRequest request) {
        Product product = Product.builder()
            .productName(request.productName())
            .brandName(request.brandName())
            .internalName(request.internalName())
            .description(request.description())
            .introductionDate(request.introductionDate())
            .salesDiscontinuationDate(request.salesDiscontinuationDate())
            .build();

        List<ProductPrice> productPrices = request.productPrices().stream()
            .map(pp -> {
                ProductPriceType productPriceType = productPriceTypeRepository
                    .findById(pp.productPriceTypeId())
                    .orElse(null);
                if (productPriceType == null) {
                    throw new IllegalArgumentException("productPriceType not found.");
                }

                return ProductPrice.builder()
                    .price(pp.price())
                    .currencyUomId(pp.currencyUomId())
                    .priceType(productPriceType)
                    .fromDate(pp.fromDate())
                    .thruDate(pp.thruDate())
                    .build();
            }).toList();

        product.setPrices(productPrices);

        return productRepository.save(product);
    }
}