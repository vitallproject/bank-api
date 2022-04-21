package com.vital.bank.dto;

import java.math.BigDecimal;

public record FundsTransferRequestDto(
         String fromAccount,
         String toAccount,
         BigDecimal amount) {}
