package com.riwi.diagnostic.test.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CouponResponse {
    private String id;
    private String status;
    private String description;
    private Double percentage;
    private LocalDateTime createdAt;
    private LocalDateTime expirationDate;
}
