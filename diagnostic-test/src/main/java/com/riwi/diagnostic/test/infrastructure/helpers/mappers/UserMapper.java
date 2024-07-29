package com.riwi.diagnostic.test.infrastructure.helpers.mappers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import com.riwi.diagnostic.test.api.dto.requests.UserRequest;
import com.riwi.diagnostic.test.api.dto.response.UserResponse;
import com.riwi.diagnostic.test.domain.entities.Sales;
import com.riwi.diagnostic.test.domain.entities.User;
import com.riwi.diagnostic.test.domain.repositories.SaleRepository;
import com.riwi.diagnostic.test.infrastructure.helpers.HelperToFind;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @InheritInverseConfiguration
    @Mapping(target = "sales", ignore = true)
    UserResponse entityToResponse(User entity);


    default User requestToEntity(UserRequest request, @SuppressWarnings("rawtypes") HelperToFind finder) {
        if ( request == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();
        List<Sales> sales = request.getSales().stream().map(finder::findById(SaleRepository, request.getSales(), "sales"));
        user.email( request.getEmail() );
        user.name( request.getName() );
        user.createdAt( LocalDateTime.now() );
        user.sales(sales);
        sales.add();
        return user.build();
    }


}
