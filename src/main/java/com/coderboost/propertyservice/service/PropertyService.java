package com.coderboost.propertyservice.service;

import com.coderboost.propertyservice.dto.request.PropertyCreateDto;

public interface PropertyService {

    void addProperty(PropertyCreateDto propertyCreateDto);
}
