package com.example.banksystem.service;

import com.example.banksystem.repository.AddressRepo;
import com.example.banksystem.repository.IssuerBranchRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssuerBranchService {

    private ModelMapper modelMapper;
    private IssuerBranchRepo issuerBranchRepo;

    @Autowired
    public IssuerBranchService(ModelMapper modelMapper, IssuerBranchRepo issuerBranchRepo) {
        this.modelMapper = modelMapper;
        this.issuerBranchRepo = issuerBranchRepo;
    }
}
