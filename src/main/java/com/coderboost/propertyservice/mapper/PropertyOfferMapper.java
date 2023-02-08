package com.coderboost.propertyservice.mapper;


import com.coderboost.propertyservice.dto.request.OfferCreateDto;
import com.coderboost.propertyservice.dto.response.PropertyOfferDto;
import com.coderboost.propertyservice.entity.PropertyOffer;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static com.coderboost.propertyservice.enums.OfferStatus.AVAILABLE;

public class PropertyOfferMapper {
    public static PropertyOfferDto toDto(PropertyOffer offer) {
        return new PropertyOfferDto(offer.getId(), offer.getProperty().getName(), offer.getProperty().getDetail(),
                offer.getStatus(), offer.getOwner().getName(), offer.getOwner().getUserId(), offer.getCreatedAt(),
                offer.getUpdatedAt(), offer.getAmount(), offer.getCustomer().getName(), offer.getCustomer().getUserId());
    }

    public static List<PropertyOfferDto> toListDto(List<PropertyOffer> offers) {
        List<PropertyOfferDto> offerDtoList = new ArrayList<>();
        for (PropertyOffer offer : offers) {
            offerDtoList.add(toDto(offer));
        }
        return offerDtoList;
    }

    public static PropertyOffer.PropertyOfferBuilder toPropertyOffersEntityBuilder(OfferCreateDto offerCreateDto) {
        return PropertyOffer.builder()
                .status(AVAILABLE)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .amount(offerCreateDto.getAmount());
    }

}
