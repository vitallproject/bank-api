package com.vital.bank.controller;

import com.vital.bank.dto.FundsTransferRequestDto;
import com.vital.bank.dto.FundsTransferResponseDto;
import com.vital.bank.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping(value = "/funds-transfer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public FundsTransferResponseDto fundsTransfer(@RequestBody FundsTransferRequestDto fundsTransferRequestDto) {
        
        log.info("Funds transfer initiated in core bank from {}", fundsTransferRequestDto);
        return transactionService.fundsTransfer(fundsTransferRequestDto);

    }
}
