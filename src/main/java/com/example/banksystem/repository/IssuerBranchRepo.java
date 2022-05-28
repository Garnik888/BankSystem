package com.example.banksystem.repository;

import com.example.banksystem.domain.entity.Address;
import com.example.banksystem.domain.entity.IssuerBranch;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IssuerBranchRepo extends JpaRepository<IssuerBranch, Long> {

    @Override
    <S extends IssuerBranch> Optional<S> findOne(Example<S> example);
}
