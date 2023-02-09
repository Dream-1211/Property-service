package com.coderboost.propertyservice.dto.request;

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
}
