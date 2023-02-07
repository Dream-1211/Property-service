package com.coderboost.propertyservice.mapper;

import com.coderboost.propertyservice.dto.CustomerDto;
import com.coderboost.propertyservice.dto.response.OwnerDto;
import com.coderboost.propertyservice.entity.Owner;

import java.util.ArrayList;
import java.util.List;


public class OwnerMapper {

    public static List<OwnerDto> toListDto(List<Owner> owners) {

        List<OwnerDto> ownerDtoList = new ArrayList<>();
        for(Owner owner: owners ){
            ownerDtoList.add(new OwnerDto(owner.getName(), owner.getUserId(), owner.getAddress().getStreet(),
                    owner.getAddress().getZipCode(), owner.getAddress().getState(), owner.getAddress().getLongitude(),
                    owner.getAddress().getLatitude(), owner.getStatus()));
        }

        return ownerDtoList;
    }

}
