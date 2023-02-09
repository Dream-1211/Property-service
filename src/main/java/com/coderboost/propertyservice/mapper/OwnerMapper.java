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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.coderboost.propertyservice.enums.UserStatus.INACTIVE;


public class OwnerMapper {

    public static List<OwnerDto> toListDto(List<Owner> owners) {
        return owners.stream().map(OwnerMapper::toDto).toList();
    }

    public static OwnerDto toDto(Owner owner) {
        return new OwnerDto(owner.getId(), owner.getName(), owner.getUserId(), owner.getAddress().getStreet(),
                owner.getAddress().getZipCode(), owner.getAddress().getState(), owner.getStatus());
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
        return Owner.builder()
                .name(ownerDto.getName())
                .userId(ownerDto.getUserId())
                .address(new Address(0, ownerDto.getStreet(), ownerDto.getZipCode(), ownerDto.getState()))
                .status(INACTIVE)
                .build();
    }
}
