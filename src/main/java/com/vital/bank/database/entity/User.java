package com.vital.bank.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java .util.List;

@Data
@ToString(exclude = "accounts")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String identificationNumber;

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BankAccount> accounts = new ArrayList<>();

    public void addBankAccount(BankAccount account) {
        this.accounts.add(account);
        account.setUser(this);
    }
}
