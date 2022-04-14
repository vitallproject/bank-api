package com.vital.bank.service;

import com.vital.bank.database.entity.BankAccount;
import com.vital.bank.database.entity.Transaction;
import com.vital.bank.database.entity.TransactionType;
import com.vital.bank.database.repository.BankAccountRepository;
import com.vital.bank.database.repository.TransactionRepository;
import com.vital.bank.dto.FundsTransferRequest;
import com.vital.bank.dto.FundsTransferResponse;
import com.vital.bank.exception.EntityNotFoundException;
import com.vital.bank.exception.InsufficientFundsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionService {

    private final BankAccountRepository bankAccountRepository;
    private final TransactionRepository transactionRepository;

    public FundsTransferResponse fundsTransfer(FundsTransferRequest fundsTransferRequest) {
        var transactionId = UUID.randomUUID().toString();

        var fromBankAccount = bankAccountRepository.findByNumber(fundsTransferRequest.fromAccount())
                .orElseThrow(EntityNotFoundException::new);
        var toBankAccount = bankAccountRepository.findByNumber(fundsTransferRequest.toAccount())
                .orElseThrow(EntityNotFoundException::new);

        validateBalance(fromBankAccount, fundsTransferRequest.amount());

        fromBankAccount.setBalance(fromBankAccount.getBalance().subtract(fundsTransferRequest.amount()));
        toBankAccount.setBalance(toBankAccount.getBalance().add(fundsTransferRequest.amount()));

        transactionRepository.save(Transaction.builder().transactionType(TransactionType.FUNDS_TRANSFER)
                .toAccountNumber(toBankAccount.getNumber())
                .transactionId(transactionId)
                .bankAccount(fromBankAccount)
                .amount(fundsTransferRequest.amount()).build());

        return FundsTransferResponse.builder()
                .message("Payment to account:%s was successfully processed".formatted(toBankAccount.getNumber()))
                .transactionId(transactionId).build();
    }

    private void validateBalance(BankAccount bankAccount, BigDecimal amount) {
        if (bankAccount.getBalance().compareTo(BigDecimal.ZERO) < 0 || bankAccount.getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException("Insufficient funds in the account " + bankAccount.getNumber());
        }
    }
}
