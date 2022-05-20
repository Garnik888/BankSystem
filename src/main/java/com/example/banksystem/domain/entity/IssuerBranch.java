package com.example.banksystem.domain.entity;

import com.example.banksystem.domain.enum_types.IssuerType;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "issuer_branche")
public class IssuerBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "bank_name", nullable = false)
    private String bankName;
    @Column(name = "bank_code", nullable = false)
    private String bankCode;
    @Column(name = "issuer_type", nullable = false)
    private IssuerType issuerType;

    @OneToMany(mappedBy = "issuerBranch", cascade = {CascadeType.PERSIST})
    private List<Account> accountList = new ArrayList<>();

    @OneToMany(mappedBy = "issuerBranch", cascade = {CascadeType.PERSIST})
    private List<Card> cardList = new ArrayList<>();
}
