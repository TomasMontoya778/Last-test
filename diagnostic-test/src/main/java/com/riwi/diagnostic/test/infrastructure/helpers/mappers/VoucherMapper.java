package com.riwi.diagnostic.test.infrastructure.helpers.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.riwi.diagnostic.test.api.dto.requests.CouponRequest;
import com.riwi.diagnostic.test.api.dto.requests.Update.CouponUpdateRequest;
import com.riwi.diagnostic.test.api.dto.response.CouponResponse;
import com.riwi.diagnostic.test.domain.entities.Voucher;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VoucherMapper {

    Voucher toEntity (CouponRequest request);
    
    @InheritInverseConfiguration
    CouponResponse toResponse(Voucher entity);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "createdAt", ignore = true),
        @Mapping(target = "isActive", ignore = true),
        @Mapping(target = "user", ignore = true),
    })
    Voucher toEntityUpdate (CouponUpdateRequest request);


    List<Voucher> toEntityList(List<CouponRequest> requests);

    List<CouponResponse> toResponseList(List<Voucher> entities);

}
