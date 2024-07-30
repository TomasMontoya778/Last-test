package com.riwi.diagnostic.test.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.diagnostic.test.api.dto.errors.BaseErrorResponse;
import com.riwi.diagnostic.test.api.dto.requests.CouponRequest;
import com.riwi.diagnostic.test.api.dto.requests.Update.CouponUpdateRequest;
import com.riwi.diagnostic.test.api.dto.response.CouponResponse;
import com.riwi.diagnostic.test.infrastructure.services.VoucherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


import lombok.AllArgsConstructor;

@Tag(name = "Voucher's Controller", description = "Vouchers management controller")
@RestController
@RequestMapping(path = "vouchers")
@AllArgsConstructor
public class VoucherController {

    @Autowired
    private VoucherService voucherService;


    /*----------------------
     * GET ALL VOUCHERS
     * ---------------------
     */
    // SWAGGER
    @Operation(
        summary = "Get all Vouchers",
        description = "Retrieve a paginated list of all vouchers",
        parameters = {
            @Parameter(
                name = "page", 
                description = "Page number", 
                schema = @Schema(type = "integer", defaultValue = "1")),
            @Parameter(
                name = "size", 
                description = "Page size", 
                schema = @Schema(type = "integer", defaultValue = "10")),
            @Parameter(
                name = "status", 
                description = "Filter by voucher status: 'active'", 
                schema = @Schema(type = "string", defaultValue = "active")),
            @Parameter(
                name = "name", 
                description = "Filter by name of voucher", 
                schema = @Schema(type = "string"))
        },
         responses = {
            @ApiResponse(
                responseCode = "200", description = "SUCCESSFUL", 
                content = @Content(schema = @Schema(implementation = Page.class))),
            @ApiResponse(
                responseCode = "400", description = "BAD REQUEST", 
                content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))),
            @ApiResponse(
                responseCode = "401", description = "NOT AUTHORIZED", 
                content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))),
            @ApiResponse(
                responseCode = "403", description = "FORBIDDEN ACCESS", 
                content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))),
            @ApiResponse(
                responseCode = "500", description = "INTERNAL SERVER ERROR", 
                content = @Content(schema = @Schema(implementation = BaseErrorResponse.class)))
        }
    )
    @GetMapping
    public ResponseEntity<Page<CouponResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size)
            {

        PageRequest pageable = PageRequest.of(page - 1, size);
        Page<CouponResponse> studentResponsesPage = voucherService.getAll(pageable);
        return ResponseEntity.ok(studentResponsesPage);
    }

    /*--------------------
     * GET BY ID
     * -------------------
     */
   @Operation(
    summary = "Get Voucher by ID", 
    description = "Get a voucher by their ID"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200", 
            description = "SUCCESSFUL", 
            content = @Content(schema = @Schema(implementation = CouponResponse.class))
        ),
        @ApiResponse(
            responseCode = "400", 
            description = "BAD REQUEST", 
            content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))
        ),
        @ApiResponse(
            responseCode = "401", 
            description = "NOT AUTHORIZED", 
            content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))
        ),
        @ApiResponse(
            responseCode = "403", 
            description = "FORBIDDEN ACCESS", 
            content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))
        ),
        @ApiResponse(
            responseCode = "500", 
            description = "INTERNAL SERVER ERROR", 
            content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))
        )
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<CouponResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok(this.voucherService.getById(id).orElse(null));
    }

    /*--------------------
     * CREATE VOUCHER
     * -------------------
     */
    @PostMapping  
    public ResponseEntity <CouponResponse> create (@RequestBody CouponRequest request){
        CouponResponse studentResponse = this.voucherService.create(request);
        return ResponseEntity.ok(studentResponse);
    }

     
    /*--------------------
     * UPDATE VOUCHER
     * -------------------
     */
    @PutMapping(path = "/{id}")
    public ResponseEntity <CouponResponse> update (@PathVariable String id, @RequestBody CouponUpdateRequest request){
        CouponResponse studentResponse = this.voucherService.update(id, request);
        return ResponseEntity.ok(studentResponse);
    }

     /*--------------------
     * DISABLE VOUCHER
     * -------------------
     */


    @Operation(
        summary = "Disable a voucher by ID",
        description = "Disables a voucher by their ID",
        responses = {
            @ApiResponse(
                responseCode = "200", description = "SUCCESSFUL", 
                content = @Content(schema = @Schema(implementation = Page.class))),
            @ApiResponse(
                responseCode = "400", description = "BAD REQUEST", 
                content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))),
            @ApiResponse(
                responseCode = "401", description = "NOT AUTHORIZED", 
                content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))),
            @ApiResponse(
                responseCode = "403", description = "FORBIDDEN ACCESS", 
                content = @Content(schema = @Schema(implementation = BaseErrorResponse.class))),
            @ApiResponse(
                responseCode = "500", description = "INTERNAL SERVER ERROR", 
                content = @Content(schema = @Schema(implementation = BaseErrorResponse.class)))
        }
    )

    @PatchMapping (path = "/{id}/disable")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.voucherService.delete(id);
        return ResponseEntity.ok().build();
    }

   
    
    
    
}
