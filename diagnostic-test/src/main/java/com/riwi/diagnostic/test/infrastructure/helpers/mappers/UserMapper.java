package com.riwi.diagnostic.test.infrastructure.helpers.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.riwi.diagnostic.test.api.dto.requests.UserRequest;
import com.riwi.diagnostic.test.api.dto.response.UserResponse;
import com.riwi.diagnostic.test.domain.entities.User;



@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @InheritInverseConfiguration
    @Mapping(target = "sales", ignore = true)
    UserResponse entityToResponse(User entity);

    @Mapping(target = "sales", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    User requestToEntity(UserRequest request);

    default Page<UserResponse> userPageToUserResponses(Page<User> users, int page, int size){
        List<UserResponse> userResponses = users.stream()
        .map(this::entityToResponse)
        .collect(Collectors.toList());
        Pageable pageable = PageRequest.of(page, size);
        return new PageImpl<>(userResponses, pageable, users.getTotalElements());
    }

}
