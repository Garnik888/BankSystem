package com.example.banksystem.service;

import com.example.banksystem.dto.AddressDto;
import com.example.banksystem.mappers.ModelMapperConfig;
import com.example.banksystem.repository.AddressRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    private ModelMapper modelMapper;
    private AddressRepo addressRepo;

    @Autowired
    public AddressService(ModelMapper modelMapper, AddressRepo addressRepo) {
        this.modelMapper = modelMapper;
        this.addressRepo = addressRepo;
    }

}
