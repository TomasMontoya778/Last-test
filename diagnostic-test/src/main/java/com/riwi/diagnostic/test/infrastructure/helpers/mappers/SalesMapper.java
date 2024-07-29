package com.riwi.diagnostic.test.infrastructure.helpers.mappers;


import com.riwi.diagnostic.test.api.dto.requests.PurchaseRequest;
import com.riwi.diagnostic.test.api.dto.response.PurchaseResponse;
import com.riwi.diagnostic.test.domain.entities.Sales;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SalesMapper {

    @Mapping(target = "id", ignore = true)
    Sales SalesToEntity(PurchaseRequest purchaseRequest);

    PurchaseResponse EntityToSalesResponse(Sales sales);

    void updateSales(PurchaseRequest purchaseRequest, @MappingTarget Sales sales);
}
