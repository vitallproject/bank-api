package com.vital.bank.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class UserReadDto {

    Long id;
    String firstName;
    String lastName;
    String email;
    String identificationNumber;

}
