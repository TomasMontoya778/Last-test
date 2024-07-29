package com.riwi.diagnostic.test.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(title = "api for Coupon Management and Redemption System", 
        version = "1.0", 
        description = "this api allows to manage and redeem coupons in an efficient way, it includes the end points to create, update, delete and redeem coupons, also the api allows the whole process of a coupon including user, product and purchase management. "))
public class OpenApiConfig {
}
