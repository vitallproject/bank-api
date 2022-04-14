package com.vital.bank.dto;

import java.math.BigDecimal;

public record FundsTransferRequest(
         String fromAccount,
         String toAccount,
         BigDecimal amount) {}
