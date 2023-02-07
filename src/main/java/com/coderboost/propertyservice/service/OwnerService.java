package com.coderboost.propertyservice.service;

import com.coderboost.propertyservice.dto.response.OwnerDto;

import java.util.List;

public interface OwnerService {
    List<OwnerDto> getAllOwners();
}
