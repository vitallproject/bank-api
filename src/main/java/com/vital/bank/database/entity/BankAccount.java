package com.vital.bank.database.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString(exclude = {"user", "transaction"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @Enumerated(EnumType.STRING)
    private BankAccountType type;

    @Enumerated(EnumType.STRING)
    private BankAccountStatus status;

    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @Builder.Default
    @OneToMany(mappedBy = "bankAccount")
    private List<Transaction> transaction = new ArrayList<>();
}
