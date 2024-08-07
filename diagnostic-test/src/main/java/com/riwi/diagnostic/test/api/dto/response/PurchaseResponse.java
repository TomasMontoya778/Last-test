package com.riwi.diagnostic.test.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseResponse {

    private String Id;
    private String purchaseId;
    private Long quantity;
    private Double totalPrice;
}
