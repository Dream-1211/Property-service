package com.coderboost.propertyservice.mapper;

import com.coderboost.propertyservice.dto.request.PropertyCreateDto;
import com.coderboost.propertyservice.dto.request.PropertyImageRequestDto;
import com.coderboost.propertyservice.entity.Property;
import com.coderboost.propertyservice.entity.PropertyImage;
import com.coderboost.propertyservice.entity.PropertyLocation;

import java.util.List;

public class PropertyMapper {

    public static Property.PropertyBuilder toPropertyEntityBuilder(PropertyCreateDto propertyCreateDto) {

        return Property.builder()
                .name(propertyCreateDto.getName())
                .detail(propertyCreateDto.getDetail())
                .location(new PropertyLocation(propertyCreateDto.getAddress(), propertyCreateDto.getLatitude(), propertyCreateDto.getLongitude()))
                .category(propertyCreateDto.getCategory())
                .status(propertyCreateDto.getStatus())
                .isActive(propertyCreateDto.isActive())
                .images(toPropertyImageEntityList(propertyCreateDto.getImages()));
    }

    private static List<PropertyImage> toPropertyImageEntityList(List<PropertyImageRequestDto> images) {
        return images.stream().map(image ->
                PropertyImage.builder()
                        .name(image.getName())
                        .type(image.getType())
                        .data(image.getData())
                        .build()
        ).toList();
    }
}
