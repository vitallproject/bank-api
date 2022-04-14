package com.vital.bank.service;

import com.vital.bank.database.repository.BankAccountRepository;
import com.vital.bank.dto.BankAccountReadDto;
import com.vital.bank.mapper.BankAccountReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BankAccountService {

    private final BankAccountReadMapper bankAccountReadMapper;
    private final BankAccountRepository bankAccountRepository;

    public Optional<BankAccountReadDto> findByBankAccountNumber(String accountNumber) {
        return bankAccountRepository.findByNumber(accountNumber)
                .map(bankAccountReadMapper::map);
    }
}
