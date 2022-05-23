package com.example.banksystem.service;

import com.example.banksystem.repository.AddressRepo;
import com.example.banksystem.repository.CardHolderRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardHolderService {

    private ModelMapper modelMapper;
    private CardHolderRepo cardHolderRepo;

    @Autowired
    public CardHolderService(ModelMapper modelMapper, CardHolderRepo cardHolderRepo) {
        this.modelMapper = modelMapper;
        this.cardHolderRepo = cardHolderRepo;
    }
}
