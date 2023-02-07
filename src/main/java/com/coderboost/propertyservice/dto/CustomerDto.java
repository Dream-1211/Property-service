package com.coderboost.propertyservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    String name;
    long userId;
    String street;
    String zipCode;
    String state;
    String latitude;
    String longitude;
}
