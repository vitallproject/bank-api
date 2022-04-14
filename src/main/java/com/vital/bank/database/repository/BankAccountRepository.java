package com.vital.bank.database.repository;

import com.vital.bank.database.entity.BankAccount;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    @EntityGraph(attributePaths = "user")
    Optional<BankAccount> findByNumber(String number);

}
