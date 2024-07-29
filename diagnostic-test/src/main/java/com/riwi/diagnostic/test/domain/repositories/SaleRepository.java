package com.riwi.diagnostic.test.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.diagnostic.test.domain.entities.Sales;

public interface SaleRepository extends JpaRepository<Sales, String> {

}
