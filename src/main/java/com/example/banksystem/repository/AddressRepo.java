package com.example.banksystem.repository;

import com.example.banksystem.domain.entity.Address;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

  //  public Address findAddressByCountryAndCityAndStreet(String country, String city, String street);
}
