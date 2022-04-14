package com.vital.bank.dto;

import com.vital.bank.database.entity.BankAccountStatus;
import com.vital.bank.database.entity.BankAccountType;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class BankAccountReadDto {

    Long id;
    String number;
    BankAccountType type;
    BankAccountStatus status;
    BigDecimal balance;
    UserReadDto userReadDto;
}
