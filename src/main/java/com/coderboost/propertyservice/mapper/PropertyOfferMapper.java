package com.coderboost.propertyservice.mapper;


import com.coderboost.propertyservice.dto.CustomerDto;
import com.coderboost.propertyservice.dto.response.PropertyOfferDto;
import com.coderboost.propertyservice.entity.Customer;
import com.coderboost.propertyservice.entity.PropertyOffers;

import java.util.ArrayList;
import java.util.List;

public class PropertyOfferMapper {
    public static PropertyOfferDto toDto(PropertyOffers offer) {
        return new PropertyOfferDto(offer.getId(), offer.getProperty().getName(), offer.getProperty().getDetail(),
                offer.getStatus(), offer.getOwner().getName(),offer.getOwner().getUserId(), offer.getCreatedAt(),
                offer.getUpdatedAt(), offer.getAmount(), offer.getCustomer().getName(), offer.getCustomer().getUserId() );
    }

    public static List<PropertyOfferDto> toListDto(List<PropertyOffers> offers) {
        List<PropertyOfferDto> offerDtoList = new ArrayList<>();
        for (PropertyOffers offer : offers) {
            offerDtoList.add(toDto(offer));
        }
        return offerDtoList;
    }

}
