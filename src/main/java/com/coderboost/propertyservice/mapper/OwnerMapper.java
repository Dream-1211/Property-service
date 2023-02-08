package com.coderboost.propertyservice.mapper;

import com.coderboost.propertyservice.dto.request.NewOwnerDto;
import com.coderboost.propertyservice.dto.response.OwnerDetailsDto;
import com.coderboost.propertyservice.dto.response.OwnerDto;
import com.coderboost.propertyservice.dto.response.PropertyDetailsDto;
import com.coderboost.propertyservice.dto.response.PropertyDto;
import com.coderboost.propertyservice.dto.response.PropertyImagesDto;
import com.coderboost.propertyservice.entity.Address;
import com.coderboost.propertyservice.entity.Owner;
import com.coderboost.propertyservice.entity.Property;
import com.coderboost.propertyservice.entity.PropertyImage;
import com.coderboost.propertyservice.entity.PropertyLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class OwnerMapper {

    public static List<OwnerDto> toListDto(List<Owner> owners) {

        List<OwnerDto> ownerDtoList = new ArrayList<>();
        for (Owner owner : owners) {
            ownerDtoList.add(new OwnerDto(owner.getId(), owner.getName(), owner.getUserId(), owner.getAddress().getStreet(),
                    owner.getAddress().getZipCode(), owner.getAddress().getState(), owner.getAddress().getLongitude(),
                    owner.getAddress().getLatitude(), owner.getStatus()));
        }

        return ownerDtoList;
    }

    public static OwnerDto toDto(Owner owner) {
        return new OwnerDto(owner.getId(), owner.getName(), owner.getUserId(), owner.getAddress().getStreet(),
                owner.getAddress().getZipCode(), owner.getAddress().getState(), owner.getAddress().getLongitude(),
                owner.getAddress().getLatitude(), owner.getStatus());
    }

    public static OwnerDetailsDto toOwnerDetailsDto(Owner owner) {

        List<PropertyDetailsDto> properties = new ArrayList<>();

        for (Property property : owner.getProperty()) {

            List<PropertyImagesDto> imagesDtos = property.getImages().size() > 0 ?
                    property.getImages().stream().map(propImg -> new PropertyImagesDto(propImg.getId(), propImg.getName(), propImg.getType(), propImg.getData())).collect(Collectors.toList()) : new ArrayList<>();

            properties.add(new PropertyDetailsDto(property.getName(), property.getDetail(), property.getCategory(), property.getStatus(),
                    property.isActive(), property.getPrice(), property.getLocation().getAddress(), property.getLocation().getLatitude(), property.getLocation().getLongitude(), imagesDtos));
        }

        return new OwnerDetailsDto(toDto(owner), new PropertyDto(properties));
    }

    public static Owner toNewOwnerEntity(NewOwnerDto ownerDto) {

        List<Property> properties = new ArrayList<>();
        for (PropertyDetailsDto property : ownerDto.getPropertyDto().getProperties()) {

            List<PropertyImage> images = property.getImages().size() > 0 ?
                    property.getImages().stream().map(propImg -> new PropertyImage(propImg.getId(), propImg.getName(), propImg.getType(), propImg.getData())).collect(Collectors.toList()) : new ArrayList<>();

            properties.add(
                    Property.builder()
                            .name(property.getName())
                            .location(new PropertyLocation(property.getAddress(), property.getLatitude(), property.getLongitude()))
                            .detail(property.getDetail())
                            .category(property.getCategory())
                            .price(property.getPrice())
                            .images(images)
                            .build()
            );
        }
        return new Owner(ownerDto.getName(), ownerDto.getUserId(), new Address(ownerDto.getStreet(), ownerDto.getZipCode(), ownerDto.getState(), ownerDto.getLatitude(),
                ownerDto.getLongitude()), properties);
    }


}
