package com.coderboost.propertyservice.service;

import com.coderboost.propertyservice.dto.response.OwnerDetailsDto;
import com.coderboost.propertyservice.dto.response.OwnerDto;
import com.coderboost.propertyservice.enums.UserStatus;

import java.util.List;

public interface OwnerService {
    List<OwnerDto> getAllOwners();

    OwnerDetailsDto getOwnerDetailsById(long id);

    void updateOwnerStatus(long id, UserStatus status);
}
