package com.vital.bank.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FundsTransferResponseDto {

    String message;
    String transactionId;

}
