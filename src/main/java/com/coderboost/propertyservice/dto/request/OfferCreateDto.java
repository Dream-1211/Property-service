package com.coderboost.propertyservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OfferCreateDto {
    long customerId;
    long ownerId;
    long propertyId;
    double amount;
}


