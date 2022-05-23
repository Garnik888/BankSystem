package com.example.banksystem.service;

import com.example.banksystem.repository.AddressRepo;
import com.example.banksystem.repository.CardRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    private ModelMapper modelMapper;
    private CardRepo cardRepo;

    @Autowired
    public CardService(ModelMapper modelMapper, CardRepo cardRepo) {
        this.modelMapper = modelMapper;
        this.cardRepo = cardRepo;
    }


}
