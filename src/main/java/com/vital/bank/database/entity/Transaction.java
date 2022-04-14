package com.vital.bank.database.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Data
@ToString(exclude = "bankAccount")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private String toAccountNumber;

    private String transactionId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private BankAccount bankAccount;

}
