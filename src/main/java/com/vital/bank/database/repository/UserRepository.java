package com.vital.bank.database.repository;

import com.vital.bank.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface UserRepository extends
        JpaRepository<User, Long>,
        QuerydslPredicateExecutor<User> {

    Optional<User> findByIdentificationNumber(String identificationNumber);
}
