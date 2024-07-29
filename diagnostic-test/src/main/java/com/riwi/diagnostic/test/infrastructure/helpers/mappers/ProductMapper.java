package com.riwi.diagnostic.test.infrastructure.helpers.mappers;

import com.riwi.diagnostic.test.api.dto.requests.ProductRequest;
import com.riwi.diagnostic.test.api.dto.response.ProductResponse;
import com.riwi.diagnostic.test.domain.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "sales", ignore = true)
    Product productRequestToProduct(ProductRequest request);

    ProductResponse productToProductResponse(Product product);
}
