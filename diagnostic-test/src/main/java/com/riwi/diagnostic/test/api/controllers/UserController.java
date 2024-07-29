package com.riwi.diagnostic.test.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.diagnostic.test.api.dto.errors.BaseErrorResponse;
import com.riwi.diagnostic.test.api.dto.requests.UserRequest;
import com.riwi.diagnostic.test.api.dto.response.UserResponse;
import com.riwi.diagnostic.test.infrastructure.abstracts_services.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Tag(name = "Endpoints User")
public class UserController {
    @Autowired
    private final IUserService userService;
    
    @Operation(
        summary = "Get all Users",
        description = "Retrieve a paginated list of all users",
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
                name = "username", 
                description = "Filter by username", 
                schema = @Schema(type = "string")),
            @Parameter( 
                name = "email", 
                description = "Filter by email", 
                schema = @Schema(type = "string")),
        },
         responses = {
            @ApiResponse(
                responseCode = "200", description = "SUCCESSFUL", 
                content = @Content(schema = @Schema(implementation = Page.class))),
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
    @PostMapping("/create")
    public ResponseEntity<UserResponse> create(@Validated @RequestBody UserRequest request){
        return ResponseEntity.ok(userService.create(request));
    }
    @Operation(
        summary = "Get all Users",
        description = "Retrieve a paginated list of all users",
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
                name = "username", 
                description = "Filter by username", 
                schema = @Schema(type = "string")),
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
        })
    @GetMapping("/all")
    public ResponseEntity<Page<UserResponse>> getAll(@Validated Pageable pageable){
        return ResponseEntity.ok(userService.getAll(pageable));
    }
}
