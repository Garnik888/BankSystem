package com.example.banksystem.repository;

import com.example.banksystem.domain.entity.Address;
import com.example.banksystem.dto.request.AddressRequestDto;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

    @Override
    <S extends Address> Optional<S> findOne(Example<S> example);
}
