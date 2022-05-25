package com.example.banksystem.service;


import com.example.banksystem.domain.entity.Address;
import com.example.banksystem.domain.entity.IssuerBranch;
import com.example.banksystem.dto.request.AddressRequestDto;
import com.example.banksystem.dto.request.CardHolderAddressRequestDto;
import com.example.banksystem.dto.request.IssuerBranchRequestDto;
import com.example.banksystem.dto.response.AddressResponseDto;
import com.example.banksystem.dto.response.CardHolderAddressResponseDto;
import com.example.banksystem.dto.response.IssuerBranchResponseDto;
import com.example.banksystem.repository.AddressRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

    public AddressResponseDto saveAddress(AddressRequestDto addressRequestDto) {

        Address address = this.modelMapper.map(addressRequestDto,
                Address.class);

        return this.modelMapper.map(this.addressRepo.save(address), AddressResponseDto.class);
    }

    public AddressResponseDto updateAddressById(Long id, AddressRequestDto addressRequestDto) {

        Optional<Address> addressUpdate = addressRepo.findById(id);

        Address address = modelMapper.map(addressUpdate, Address.class);

        if (addressUpdate.isPresent()) {
            address.setCountry(addressRequestDto.getCountry());
            address.setCity(addressRequestDto.getCity());
            address.setStreet(addressRequestDto.getStreet());

            return modelMapper.map(addressRepo.save(address), AddressResponseDto.class);
        }

        return null;
    }

    public AddressResponseDto deleteAddressById(Long id) {

        Optional<Address> addressDelete = addressRepo.findById(id);
        Address address = modelMapper.map(addressDelete, Address.class);

        if (addressDelete.isPresent()) {

            addressRepo.delete(address);
            return modelMapper.map(address, AddressResponseDto.class);
        }

        return null;
    }

    public AddressRequestDto getAddressRequestDto(AddressRequestDto addressRequestDto) {

        Address addressGet = modelMapper.map(addressRequestDto, Address.class);
        Example<Address> example = Example.of(addressGet);
        Optional<Address> address = addressRepo.findOne(example);

        if (address.isPresent()) {

            return modelMapper.map(address, AddressRequestDto.class);
        }

        return null;
    }
}
