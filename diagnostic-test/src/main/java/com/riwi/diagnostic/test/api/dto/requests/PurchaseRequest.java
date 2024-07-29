package com.riwi.diagnostic.test.api.dto.requests;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequest {

    private Long quantity;
    private Double totalPrice;

}
