package com.vital.bank.mapper;

import com.vital.bank.database.entity.BankAccount;
import com.vital.bank.dto.BankAccountReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankAccountReadMapper implements Mapper<BankAccount, BankAccountReadDto> {

    private final UserReadMapper userReadMapper;

    @Override
    public BankAccountReadDto map(BankAccount object) {
        return BankAccountReadDto.builder()
                .id(object.getId())
                .number(object.getNumber())
                .type(object.getType())
                .status(object.getStatus())
                .balance(object.getBalance())
                .userReadDto(userReadMapper.map(object.getUser()))
                .build();
    }
}
