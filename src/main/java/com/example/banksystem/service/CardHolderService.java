package com.example.banksystem.service;

import com.example.banksystem.domain.entity.Address;
import com.example.banksystem.domain.entity.CardHolder;
import com.example.banksystem.dto.request.AddressRequestDto;
import com.example.banksystem.dto.request.CardHolderAddressRequestDto;
import com.example.banksystem.dto.response.AddressResponseDto;
import com.example.banksystem.dto.response.CardHolderAddressResponseDto;
import com.example.banksystem.dto.response.CardHolderResponseDto;
import com.example.banksystem.repository.AddressRepo;
import com.example.banksystem.repository.CardHolderRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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


    public CardHolderAddressResponseDto saveCardHolder(
            CardHolderAddressRequestDto cardHolderAddressRequestDto) {

        CardHolderAddressResponseDto cardHolderAddressResponseDto = new CardHolderAddressResponseDto();

        CardHolder cardHolder = modelMapper.map(cardHolderAddressRequestDto.getCardHolderRequestDto()
                , CardHolder.class);

        Optional<Address> addressGet =
                addressService.getAddressRequestDto(cardHolderAddressRequestDto.getAddressRequestDto());


        if (addressGet.isEmpty()) {

            Address addressSave = addressRepo.save(modelMapper.map(cardHolderAddressRequestDto.

                    getAddressRequestDto(), Address.class));

            cardHolder.setAddress(addressSave);

            cardHolderAddressResponseDto.setAddressResponseDto(
                    modelMapper.map(addressSave, AddressResponseDto.class));
        } else {

            cardHolder.setAddress(modelMapper.map(addressGet, Address.class));

            cardHolderAddressResponseDto.setAddressResponseDto(
                    modelMapper.map(addressGet, AddressResponseDto.class));
        }

        cardHolderAddressResponseDto.setCardHolderResponseDto(
                modelMapper.map(cardHolderRepo.save(cardHolder), CardHolderResponseDto.class));

        return cardHolderAddressResponseDto;
    }
}
