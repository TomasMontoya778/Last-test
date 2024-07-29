package com.riwi.diagnostic.test.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.diagnostic.test.api.dto.requests.UserRequest;
import com.riwi.diagnostic.test.api.dto.response.UserResponse;
import com.riwi.diagnostic.test.domain.entities.User;
import com.riwi.diagnostic.test.domain.repositories.UserRepository;
import com.riwi.diagnostic.test.infrastructure.abstracts_services.IUserService;
import com.riwi.diagnostic.test.infrastructure.helpers.mappers.UserMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService{
    
    @Autowired
    private final UserRepository userRepository;


    @Override
    public Page<UserResponse> getAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserResponse create(UserRequest request) {
        User user = UserMapper.INSTANCE.requestToEntity(request);
        UserResponse response = UserMapper.INSTANCE.entityToResponse(userRepository.save(user));
        return response;
    }

}
