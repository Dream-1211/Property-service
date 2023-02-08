package com.coderboost.propertyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomerDto {

    long id;
    String name;
    long userId;
    String street;
    String zipCode;
    String state;
    String latitude;
    String longitude;
}
