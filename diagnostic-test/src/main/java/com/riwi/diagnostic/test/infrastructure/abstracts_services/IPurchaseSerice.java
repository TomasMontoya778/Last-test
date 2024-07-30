package com.riwi.diagnostic.test.infrastructure.abstracts_services;

import com.riwi.diagnostic.test.api.dto.requests.PurchaseRequest;
import com.riwi.diagnostic.test.api.dto.response.PurchaseResponse;
import com.riwi.diagnostic.test.infrastructure.abstracts_services.Generic.CreateService;
import com.riwi.diagnostic.test.infrastructure.abstracts_services.Generic.ReadAllService;
import com.riwi.diagnostic.test.infrastructure.abstracts_services.Generic.ReadService;

public interface IPurchaseSerice extends
    CreateService <PurchaseRequest,PurchaseResponse>,
    ReadService<PurchaseResponse,String>,
    ReadAllService<PurchaseResponse>{
    
}
