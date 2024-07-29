package com.riwi.diagnostic.test.infrastructure.abstracts_services;


import com.riwi.diagnostic.test.api.dto.requests.UserRequest;
import com.riwi.diagnostic.test.api.dto.response.UserResponse;
import com.riwi.diagnostic.test.infrastructure.abstracts_services.Generic.CreateService;
import com.riwi.diagnostic.test.infrastructure.abstracts_services.Generic.ReadService;

interface IUserService extends 
    ReadService <UserResponse, String>,
    CreateService <UserRequest,UserResponse> {
}