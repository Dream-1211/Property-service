package com.coderboost.propertyservice.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class NewCustomer {
    String name;
    long userId;
    String street;
    String zipCode;
    String state;
    String latitude;
    String longitude;
}
