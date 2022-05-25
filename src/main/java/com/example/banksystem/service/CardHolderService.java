package com.example.banksystem.service;

import com.example.banksystem.domain.entity.Address;
import com.example.banksystem.domain.entity.Card;
import com.example.banksystem.domain.entity.CardHolder;
import com.example.banksystem.dto.request.AddressRequestDto;
import com.example.banksystem.dto.request.CardHolderAddressRequestDto;
import com.example.banksystem.dto.request.CardHolderRequestDto;
import com.example.banksystem.dto.response.CardHolderAddressResponseDto;
import com.example.banksystem.dto.response.CardHolderResponseDto;
import com.example.banksystem.repository.AddressRepo;
import com.example.banksystem.repository.CardHolderRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardHolderService {

    private final ModelMapper modelMapper;
    private final CardHolderRepo cardHolderRepo;
    private final AddressService addressService;
    private final AddressRepo addressRepo;

    @Autowired
    public CardHolderService(ModelMapper modelMapper, CardHolderRepo cardHolderRepo,
                             AddressService addressService, AddressRepo addressRepo) {
        this.modelMapper = modelMapper;
        this.cardHolderRepo = cardHolderRepo;
        this.addressService = addressService;
        this.addressRepo = addressRepo;
    }


    public CardHolderResponseDto saveCardHolder(CardHolderAddressRequestDto cardHolderAddressRequestDto) {

        CardHolder cardHolder = modelMapper.map(cardHolderAddressRequestDto.getCardHolderRequestDto(),
                CardHolder.class);
        Address addressSave = modelMapper.map(cardHolderAddressRequestDto.getAddressRequestDto(),
                Address.class);


        addressRepo.save(addressSave);
        CardHolder save = cardHolderRepo.save(cardHolder);
        return modelMapper.map(save, CardHolderResponseDto.class);
    }
}
