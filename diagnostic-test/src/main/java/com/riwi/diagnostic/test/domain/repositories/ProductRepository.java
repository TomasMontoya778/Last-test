package com.riwi.diagnostic.test.domain.repositories;

import com.riwi.diagnostic.test.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}
