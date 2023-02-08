package com.coderboost.propertyservice.service;

import com.coderboost.propertyservice.dto.request.OfferCreateDto;
import com.coderboost.propertyservice.enums.OfferStatus;

public interface OfferService {

    void addNewOffer(OfferCreateDto offerCreateDto);

    void updateOfferStatus(long offerId, OfferStatus offerStatus);

}
