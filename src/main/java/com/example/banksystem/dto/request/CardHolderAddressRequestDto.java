package com.example.banksystem.dto.request;

public class CardHolderAddressRequestDto {

    CardHolderRequestDto cardHolderRequestDto;
    AddressRequestDto addressRequestDto;

    public CardHolderAddressRequestDto() {
    }

    public CardHolderAddressRequestDto(CardHolderRequestDto cardHolderRequestDto,
                                       AddressRequestDto addressRequestDto) {
        this.cardHolderRequestDto = cardHolderRequestDto;
        this.addressRequestDto = addressRequestDto;
    }

    public CardHolderRequestDto getCardHolderRequestDto() {
        return cardHolderRequestDto;
    }

    public void setCardHolderRequestDto(CardHolderRequestDto cardHolderRequestDto) {
        this.cardHolderRequestDto = cardHolderRequestDto;
    }

    public AddressRequestDto getAddressRequestDto() {
        return addressRequestDto;
    }

    public void setAddressRequestDto(AddressRequestDto addressRequestDto) {
        this.addressRequestDto = addressRequestDto;
    }
}
