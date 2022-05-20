package com.example.banksystem.repository;

import com.example.banksystem.domain.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
