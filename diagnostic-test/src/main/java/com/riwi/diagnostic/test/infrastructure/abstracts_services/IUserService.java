package com.riwi.diagnostic.test.infrastructure.abstracts_services;

import com.riwi.diagnostic.test.api.dto.requests.UserRequest;
import com.riwi.diagnostic.test.api.dto.response.UserResponse;
import com.riwi.diagnostic.test.infrastructure.abstracts_services.Generic.CreateService;
import com.riwi.diagnostic.test.infrastructure.abstracts_services.Generic.ReadAllService;

public interface IUserService extends ReadAllService<UserResponse>, 
CreateService<UserRequest,UserResponse> {

}
