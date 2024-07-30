package com.riwi.diagnostic.test.infrastructure.services;


import com.riwi.diagnostic.test.api.dto.response.ProductResponse;
import com.riwi.diagnostic.test.domain.entities.Product;
import com.riwi.diagnostic.test.domain.repositories.ProductRepository;
import com.riwi.diagnostic.test.infrastructure.abstracts_services.IProductService;
import com.riwi.diagnostic.test.infrastructure.helpers.mappers.ProductMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ProductService implements IProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;


    @Override
    public Page<ProductResponse> getAll(Pageable pageable) {
        return this.productRepository.findAll(pageable)
                .map(productMapper::productToProductResponse);
    }

    @Override
    public Optional<ProductResponse> getById(String id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID not found"));


        return productRepository.findById(id)
                .map(productMapper::productToProductResponse);
    }
}
