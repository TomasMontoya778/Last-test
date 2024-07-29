package com.riwi.diagnostic.test.api.controllers;

import com.riwi.diagnostic.test.api.dto.response.ProductResponse;
import com.riwi.diagnostic.test.infrastructure.abstracts_services.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
@AllArgsConstructor
public class ProductController {

    private final IProductService iProductService;


    /*
    --------------------
     GET BY ID
    -------------------
     */
    @Operation(summary = "Get product by ID", description = "Retrieves a product by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<ProductResponse>> get(@PathVariable String id){
        return ResponseEntity.ok(this.iProductService.getById(id));
    }

    /*
    ----------------------
     GET ALL PRODUCTS
    ---------------------
     */
    @Operation(
            summary = "Get all products",
            description = "Retrieve a paginated list of all products",
            parameters = {
                    @Parameter(name = "page",
                            description = "Page number",
                            schema = @Schema(
                                    type = "integer",
                                    defaultValue = "1")),
                    @Parameter(name = "size",
                            description = "Page size",
                            schema = @Schema(
                                    type = "integer",
                                    defaultValue = "10"))
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "SUCCESSFUL"),
                    @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
                    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
            })
    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAll(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        Page<ProductResponse> responses = this.iProductService.getAll(pageable);
        return ResponseEntity.ok(responses);
    }




}
