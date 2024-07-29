package com.riwi.diagnostic.test.infrastructure.services;

import com.riwi.diagnostic.test.api.dto.requests.PurchaseRequest;
import com.riwi.diagnostic.test.api.dto.response.PurchaseResponse;
import com.riwi.diagnostic.test.domain.entities.Sales;
import com.riwi.diagnostic.test.domain.repositories.SaleRepository;
import com.riwi.diagnostic.test.infrastructure.abstracts_services.IPurchaseSerice;
import com.riwi.diagnostic.test.infrastructure.helpers.mappers.SalesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalesService implements IPurchaseSerice {

    @Autowired
    private SaleRepository salesRepository;

    @Autowired
    private SalesMapper salesMapper;



    @Override
    public PurchaseResponse create(PurchaseRequest purchaseRequest) {

        Sales sales = salesMapper.SalesToEntity(purchaseRequest);
        Sales salesSaved = salesRepository.save(sales);

        return salesMapper.EntityToSalesResponse(salesSaved);
    }

    @Override
    public Page<PurchaseResponse> getAll(Pageable pageable) {

        return salesRepository.findAll(pageable).map(salesMapper::EntityToSalesResponse);
    }

    @Override
    public Optional<PurchaseResponse> getById(String id) {

        Sales sales = salesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID not found"));

        return salesRepository.findById(id).map(salesMapper::EntityToSalesResponse);

    }


}
