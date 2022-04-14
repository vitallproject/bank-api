package com.vital.bank.mapper;

import com.vital.bank.database.entity.User;
import com.vital.bank.dto.UserReadDto;
import org.springframework.stereotype.Component;

@Component
public class UserReadMapper implements Mapper<User, UserReadDto> {

    @Override
    public UserReadDto map(User object) {
        return UserReadDto.builder()
                .id(object.getId())
                .firstName(object.getFirstName())
                .lastName(object.getLastName())
                .email(object.getEmail())
                .identificationNumber(object.getIdentificationNumber())
                .build();
    }
}
