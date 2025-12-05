package com.sanskar.ecommerce.service;

import com.sanskar.ecommerce.dto.product.ProductResponse;
import com.sanskar.ecommerce.entity.product.Product;
import com.sanskar.ecommerce.entity.product.ProductPrice;
import com.sanskar.ecommerce.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public ProductResponse toResponse(Product product) {
        Integer defaultPrice = product.getPrices().stream()
                .filter(p -> p.getPriceType().getName().equals("DEFAULT_PRICE"))
                .map(ProductPrice::getPrice)   // extract integer price
                .findFirst()
                .orElse(null);

        int quantity = product.getInventory() != null
                ? product.getInventory().getQuantityOnHandTotal()
                : 0;

        return new ProductResponse(
                product.getId(),
                product.getProductName(),
                product.getBrandName(),
                defaultPrice,
                quantity > 0,
                quantity
        );
    }
}
