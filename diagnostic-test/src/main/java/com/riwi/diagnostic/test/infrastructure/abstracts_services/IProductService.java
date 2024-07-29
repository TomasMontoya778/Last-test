package com.riwi.diagnostic.test.infrastructure.abstracts_services;

import com.riwi.diagnostic.test.api.dto.response.ProductResponse;
import com.riwi.diagnostic.test.api.dto.response.UserResponse;
import com.riwi.diagnostic.test.infrastructure.abstracts_services.Generic.ReadAllService;
import com.riwi.diagnostic.test.infrastructure.abstracts_services.Generic.ReadService;

public interface IProductService extends
    ReadAllService <ProductResponse>,
    ReadService <UserResponse,String>{
}
