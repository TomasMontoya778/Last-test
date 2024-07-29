package com.riwi.diagnostic.test.api.dto.requests;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponRequest {
    
    @Schema(description = "Name of the Cupon", example = "zapato barato")
    @NotBlank(message = "The Student name is required")
    String name;
    @Schema(description = "Status of the Voucher,can bee true (active) or false (inactive) ", example = "true")
    Boolean status;
    @Schema(description = "Date of Creation creation in the register", example = "2024-12-31")
    LocalDateTime createdAt;
    @Schema(description = "Date of expiration", example = "2024-12-31")
    LocalDateTime expirationDate;
    @Schema(description = "Id of the Sale", example = "asdfasd12-123412asd-123rada123-123123dfa")
    String salesId;

}
