package com.riwi.diagnostic.test.domain.repositories;

import com.riwi.diagnostic.test.domain.entities.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sales, String> {

}
