package com.example.banksystem.domain.entity;

import com.example.banksystem.domain.enum_types.BalanceType;
import com.example.banksystem.domain.enum_types.CardStatus;
import com.example.banksystem.domain.enum_types.CardType;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Objects;

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

    public Card() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public BalanceType getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(BalanceType balanceType) {
        this.balanceType = balanceType;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCVC() {
        return CVC;
    }

    public void setCVC(String CVC) {
        this.CVC = CVC;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public IssuerBranch getIssuerBranch() {
        return issuerBranch;
    }

    public void setIssuerBranch(IssuerBranch issuerBranch) {
        this.issuerBranch = issuerBranch;
    }

    public CardHolder getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) && cardType == card.cardType && balanceType == card.balanceType && Objects.equals(balance, card.balance) && Objects.equals(cardNumber, card.cardNumber) && Objects.equals(expirationDate, card.expirationDate) && Objects.equals(CVC, card.CVC) && cardStatus == card.cardStatus && Objects.equals(PIN, card.PIN) && Objects.equals(issuerBranch, card.issuerBranch) && Objects.equals(cardHolder, card.cardHolder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardType, balanceType, balance, cardNumber, expirationDate, CVC, cardStatus, PIN, issuerBranch, cardHolder);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardType=" + cardType +
                ", balanceType=" + balanceType +
                ", balance='" + balance + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expirationDate=" + expirationDate +
                ", CVC='" + CVC + '\'' +
                ", cardStatus=" + cardStatus +
                ", PIN='" + PIN + '\'' +
                '}';
    }
}
