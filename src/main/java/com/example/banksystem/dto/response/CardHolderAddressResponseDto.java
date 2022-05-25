package com.example.banksystem.dto.response;

import com.example.banksystem.dto.request.AddressRequestDto;
import com.example.banksystem.dto.request.CardHolderRequestDto;

public class CardHolderAddressResponseDto {

    CardHolderResponseDto cardHolderResponseDto;
    AddressResponseDto addressResponseDto;

    public CardHolderAddressResponseDto() {
    }

    public CardHolderAddressResponseDto(CardHolderResponseDto cardHolderResponseDto, AddressResponseDto addressResponseDto) {
        this.cardHolderResponseDto = cardHolderResponseDto;
        this.addressResponseDto = addressResponseDto;
    }

    public CardHolderResponseDto getCardHolderResponseDto() {
        return cardHolderResponseDto;
    }

    public void setCardHolderResponseDto(CardHolderResponseDto cardHolderResponseDto) {
        this.cardHolderResponseDto = cardHolderResponseDto;
    }

    public AddressResponseDto getAddressResponseDto() {
        return addressResponseDto;
    }

    public void setAddressResponseDto(AddressResponseDto addressResponseDto) {
        this.addressResponseDto = addressResponseDto;
    }
}
