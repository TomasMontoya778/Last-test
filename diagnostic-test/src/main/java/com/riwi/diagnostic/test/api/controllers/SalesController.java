package com.riwi.diagnostic.test.api.controllers;

import com.riwi.diagnostic.test.api.dto.errors.ErrorsResp;
import com.riwi.diagnostic.test.api.dto.requests.PurchaseRequest;
import com.riwi.diagnostic.test.api.dto.response.PurchaseResponse;
import com.riwi.diagnostic.test.infrastructure.services.SalesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "sales")
@AllArgsConstructor
public class SalesController {

    @Autowired
    private SalesService salesService;

    @Operation(summary = "This method allows you to 'create' a discount")
    @ApiResponse(responseCode = "400", description = "\"When the request it's not valid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResp.class))
    })
    @PostMapping
    public ResponseEntity<PurchaseResponse> create(
            @Validated @RequestBody PurchaseRequest purchaseRequest
            ){

        return ResponseEntity.ok(salesService.create(purchaseRequest));
    }

    @Operation(summary = "this method allows get all the list of the in paginated form")
    @ApiResponse(responseCode = "400", description = "When the operation is successful", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResp.class)) })
    @GetMapping
    public ResponseEntity <Page<PurchaseResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size){

        Pageable pageable = PageRequest.of(page, size);
        if (page != 0) pageable = PageRequest.of(page - 1, size);

        return ResponseEntity.ok(salesService.getAll(pageable));
    }

    @Operation(summary = "This method allows you to find a discount with an specific id")
    @ApiResponse(responseCode = "400", description = "When the id it's not valid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResp.class)) })
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<PurchaseResponse>> getById(
            @PathVariable String id){

        return ResponseEntity.ok(salesService.getById(id));
    }

}
