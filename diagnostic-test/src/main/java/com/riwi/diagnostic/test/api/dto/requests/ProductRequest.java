package com.riwi.diagnostic.test.api.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {


    @NotBlank(message = "The name is required")
    private String name;

    @NotBlank(message = "The description is required")
    private String description;

    @NotNull(message = "The price is required")
    private Double price;

}
