package com.coderboost.propertyservice.dto.request;

import com.coderboost.propertyservice.enums.PropertyCategory;
import com.coderboost.propertyservice.enums.PropertyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PropertyCreateDto {
    String name;
    String detail;
    PropertyCategory category;
    PropertyStatus status;
    boolean isActive;
    long ownerId;
    String address;
    String latitude;
    String longitude;
    List<PropertyImageRequestDto> images;
}
