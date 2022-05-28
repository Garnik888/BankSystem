package com.example.banksystem.service;

import com.example.banksystem.domain.entity.Address;
import com.example.banksystem.domain.entity.CardHolder;
import com.example.banksystem.dto.request.CardHolderAddressRequestDto;
import com.example.banksystem.dto.request.CardHolderRequestDto;
import com.example.banksystem.dto.response.AddressResponseDto;
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


    public CardHolderAddressResponseDto saveCardHolder(
            CardHolderAddressRequestDto cardHolderAddressRequestDto) {

        CardHolderAddressResponseDto cardHolderAddressResponseDto = new CardHolderAddressResponseDto();

        CardHolder cardHolder = modelMapper.map(cardHolderAddressRequestDto.getCardHolderRequestDto()
                , CardHolder.class);

        getAddressAndSaveInCardHolder(cardHolderAddressRequestDto, cardHolderAddressResponseDto, cardHolder);

        cardHolderAddressResponseDto.setCardHolderResponseDto(
                modelMapper.map(cardHolderRepo.save(cardHolder), CardHolderResponseDto.class));

        return cardHolderAddressResponseDto;
    }

    public CardHolderAddressResponseDto updateCardHolder(Long id, CardHolderAddressRequestDto
            cardHolderAddressRequestDto) {

        CardHolderAddressResponseDto cardHolderAddressResponseDto = new CardHolderAddressResponseDto();

        Optional<CardHolder> cardHolderGet =cardHolderRepo.findById(id);
        CardHolder cardHolderUpdate = modelMapper.map(cardHolderGet, CardHolder.class);


        CardHolderRequestDto cardHolderRequestDto = cardHolderAddressRequestDto.getCardHolderRequestDto();

        if (cardHolderGet.isPresent()) {

            getAddressAndSaveInCardHolder(cardHolderAddressRequestDto, cardHolderAddressResponseDto,
                    cardHolderUpdate);

            cardHolderUpdate.setFirstName(cardHolderRequestDto.getFirstName());
            cardHolderUpdate.setLastName(cardHolderRequestDto.getLastName());
            cardHolderUpdate.setAge(cardHolderRequestDto.getAge());

            cardHolderAddressResponseDto.setCardHolderResponseDto(
                    modelMapper.map(cardHolderRepo.save(cardHolderUpdate), CardHolderResponseDto.class));
            return cardHolderAddressResponseDto;
        }

        return null;
    }

    public CardHolderResponseDto deleteCardHolder(Long id) {

        Optional<CardHolder> cardHolderGet = cardHolderRepo.findById(id);
        CardHolder cardHolder = modelMapper.map(cardHolderGet, CardHolder.class);

        if(cardHolderGet.isPresent()) {

            cardHolderRepo.delete(cardHolder);
            return modelMapper.map(cardHolder, CardHolderResponseDto.class);
        }

        return null;
    }

    public Optional<CardHolder> getCardHolder(CardHolderRequestDto cardHolderRequestDto) {

        CardHolder cardHolderGet = modelMapper.map(cardHolderRequestDto, CardHolder.class);
        Example<CardHolder> example = Example.of(cardHolderGet);
        Optional<CardHolder> cardHolder = cardHolderRepo.findOne(example);

        return cardHolder;
    }
    private void getAddressAndSaveInCardHolder(CardHolderAddressRequestDto cardHolderAddressRequestDto,
                                               CardHolderAddressResponseDto cardHolderAddressResponseDto,
                                               CardHolder cardHolderUpdate) {
        Optional<Address> addressGet =
                addressService.getAddress(cardHolderAddressRequestDto.getAddressRequestDto());


        if (addressGet.isEmpty()) {

            Address addressSave = addressRepo.save(modelMapper.map(cardHolderAddressRequestDto.

                    getAddressRequestDto(), Address.class));

            cardHolderUpdate.setAddress(addressSave);

            cardHolderAddressResponseDto.setAddressResponseDto(
                    modelMapper.map(addressSave, AddressResponseDto.class));
        } else {

            cardHolderUpdate.setAddress(modelMapper.map(addressGet, Address.class));

            cardHolderAddressResponseDto.setAddressResponseDto(
                    modelMapper.map(addressGet, AddressResponseDto.class));
        }
    }

}
