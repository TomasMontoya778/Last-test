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

import com.riwi.diagnostic.test.api.dto.requests.UserRequest;
import com.riwi.diagnostic.test.api.dto.response.UserResponse;
import com.riwi.diagnostic.test.infrastructure.abstracts_services.IUserService;
    
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Tag(name = "Endpoints User")
public class UserController {
    @Autowired
    private final IUserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> create(@Validated @RequestBody UserRequest request){
        return ResponseEntity.ok(userService.create(request));
    }
    @GetMapping("/all")
    public ResponseEntity<Page<UserResponse>> getAll(@Validated Pageable pageable){
        return ResponseEntity.ok(userService.getAll(pageable));
    }
}
