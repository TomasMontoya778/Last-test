package com.riwi.diagnostic.test.api.dto.requests.Update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponUpdateRequest {
    String couponId;
}
