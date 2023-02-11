package com.coderboost.propertyservice.mapper;

import com.coderboost.propertyservice.dto.request.PropertyCreateDto;
import com.coderboost.propertyservice.dto.request.PropertyImageRequestDto;
import com.coderboost.propertyservice.dto.response.PropertyDetailsDto;
import com.coderboost.propertyservice.dto.response.PropertyImagesDto;
import com.coderboost.propertyservice.entity.Property;
import com.coderboost.propertyservice.entity.PropertyImage;
import com.coderboost.propertyservice.entity.PropertyLocation;

import java.util.ArrayList;
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
                .price(propertyCreateDto.getPrice())
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

    private static List<PropertyImagesDto> toPropertyImageRequestDtoList(List<PropertyImage> images) {
        return images.stream().map(propImg -> new PropertyImagesDto(propImg.getId(), propImg.getName(), propImg.getType(), propImg.getData())).toList();
    }

    public static PropertyDetailsDto toPropertyDetailDto(Property property) {
        return new PropertyDetailsDto(
                property.getId(),
                property.getName(),
                property.getDetail(),
                property.getCategory(),
                property.getStatus(),
                property.isActive(),
                property.getPrice(),
                property.getLocation().getAddress(),
                property.getLocation().getLatitude(),
                property.getLocation().getLongitude(),
                toPropertyImageRequestDtoList(property.getImages()),
                property.getOwner().getId()
        );
    }

    public static List<PropertyDetailsDto> toPropertyDetailDtoList(List<Property> properties) {
        List<PropertyDetailsDto> propertyDetailsDtoList = new ArrayList<>();
        properties.forEach(p -> {
                    List<PropertyImagesDto> images = toPropertyImageRequestDtoList(p.getImages());
                    propertyDetailsDtoList.add(
                            new PropertyDetailsDto(
                                    p.getId(),
                                    p.getName(),
                                    p.getDetail(),
                                    p.getCategory(),
                                    p.getStatus(),
                                    p.isActive(),
                                    p.getPrice(),
                                    p.getLocation().getAddress(),
                                    p.getLocation().getLatitude(),
                                    p.getLocation().getLongitude(),
                                    images,
                                    p.getOwner().getId())
                    );
                }
        );
        return propertyDetailsDtoList;
    }
}
