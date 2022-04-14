package com.vital.bank.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FundsTransferResponse {

    String message;
    String transactionId;

}
