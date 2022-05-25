package com.example.banksystem.domain.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "address",
uniqueConstraints = @UniqueConstraint(columnNames = {"country", "city", "street"}))
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "street", nullable = false, length = 30)
    private String street;
    @Column(name = "city", nullable = false, length = 30)
    private String city;
    @Column(name = "country", nullable = false, length = 30)
    private String country;

    @OneToMany(mappedBy = "address", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<CardHolder> cardHolders =new ArrayList<>();

    public Address() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<CardHolder> getCardHolders() {
        return cardHolders;
    }

    public void setCardHolders(List<CardHolder> cardHolders) {
        this.cardHolders = cardHolders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(country, address.country) && Objects.equals(cardHolders, address.cardHolders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, city, country, cardHolders);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
