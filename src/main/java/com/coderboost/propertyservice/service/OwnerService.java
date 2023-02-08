package com.coderboost.propertyservice.service;

import com.coderboost.propertyservice.dto.request.NewOwnerDto;
import com.coderboost.propertyservice.dto.response.OwnerDetailsDto;
import com.coderboost.propertyservice.dto.response.OwnerDto;
import com.coderboost.propertyservice.dto.response.PropertyOfferDto;
import com.coderboost.propertyservice.enums.UserStatus;

import java.util.List;

public interface OwnerService {
    List<OwnerDto> getAllOwners();

    OwnerDetailsDto getOwnerDetailsById(long id);

    void updateOwnerStatus(long id, UserStatus status);

    OwnerDto getOwnerByUserId(long userId);

    List<PropertyOfferDto> getOwnerPropertyAllOffers(long id, long pid);

    void saveOwner(NewOwnerDto ownerDto);
}
