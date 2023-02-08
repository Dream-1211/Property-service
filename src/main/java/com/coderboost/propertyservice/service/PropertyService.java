package com.coderboost.propertyservice.service;

import com.coderboost.propertyservice.dto.request.PropertyCreateDto;
import com.coderboost.propertyservice.dto.response.PropertyDetailsDto;
import com.coderboost.propertyservice.enums.PropertyStatus;

import java.util.List;

public interface PropertyService {

    void addProperty(PropertyCreateDto propertyCreateDto);

    void updatePropertyStatus(long propertyId, PropertyStatus propertyStatus);

    List<PropertyDetailsDto> fetchProperties();

    void deleteProperty(long propertyId);
}
