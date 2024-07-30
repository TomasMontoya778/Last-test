package com.riwi.diagnostic.test.infrastructure.abstracts_services;

import com.riwi.diagnostic.test.api.dto.requests.CouponRequest;
import com.riwi.diagnostic.test.api.dto.requests.Update.CouponUpdateRequest;
import com.riwi.diagnostic.test.api.dto.response.CouponResponse;
import com.riwi.diagnostic.test.infrastructure.abstracts_services.Generic.*;

public interface ICouponService extends
    CreateService <CouponRequest,CouponResponse>,
    DeleteService<String>,
    UpdateService <CouponUpdateRequest,CouponResponse,String>,
    ReadService<CouponResponse,String>,
    ReadAllService<CouponResponse>{
    
}
