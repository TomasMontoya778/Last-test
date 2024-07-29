package com.riwi.diagnostic.test.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.diagnostic.test.domain.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
