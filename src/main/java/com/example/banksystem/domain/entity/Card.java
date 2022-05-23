package com.example.banksystem.domain.entity;

import com.example.banksystem.domain.enum_types.BalanceType;
import com.example.banksystem.domain.enum_types.CardStatus;
import com.example.banksystem.domain.enum_types.CardType;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "card_type", nullable = false)
    private CardType cardType;
    @Column(name = "balance_type", nullable = false)
    private BalanceType balanceType;
    @Column(name = "balance", nullable = false)
    private String balance;
    @Column(name = "card_number", nullable = false, unique = true, length = 16)
    private String cardNumber;
    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;
    @Column(name = "cvc", nullable = false, length = 3)
    private String CVC;
    @Column(name = "card_status", nullable = false)
    private CardStatus cardStatus;
    @Column(name = "pin", nullable = false, length = 4)
    private String PIN;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_issuer_branch", nullable = false,
            foreignKey = @ForeignKey(name = "issuer_branch_card_fk"))
    private IssuerBranch issuerBranch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_card_holder", nullable = false,
            foreignKey = @ForeignKey(name = "card_holder_card_fk"))
    private CardHolder cardHolder;


}
