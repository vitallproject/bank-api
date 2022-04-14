package com.vital.bank.controller;

import com.vital.bank.dto.BankAccountReadDto;
import com.vital.bank.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @GetMapping(value = "/bank-account/{account_number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BankAccountReadDto findByAccountNumber(@PathVariable("account_number") String accountNumber) {
        log.info("Reading bankAccount by accountNumber {}", accountNumber);

        return bankAccountService.findByBankAccountNumber(accountNumber)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
