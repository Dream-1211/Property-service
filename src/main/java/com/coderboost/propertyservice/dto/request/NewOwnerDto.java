package com.coderboost.propertyservice.dto.request;

import com.coderboost.propertyservice.dto.response.PropertyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewOwnerDto {

    String name;
    long userId;
    String street;
    String zipCode;
    String state;
    String latitude;
    String longitude;
    PropertyDto propertyDto;

}
