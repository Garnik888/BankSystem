package com.example.banksystem.domain.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address")
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

    @OneToMany(mappedBy = "address", cascade = {CascadeType.PERSIST})
    private List<CardHolder> cardHolders = new ArrayList<>();
}
