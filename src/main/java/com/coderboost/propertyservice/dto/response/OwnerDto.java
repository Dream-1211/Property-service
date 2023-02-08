package com.coderboost.propertyservice.dto.response;

import com.coderboost.propertyservice.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OwnerDto {

    long id;
    String name;
    long userId;
    String street;
    String zipCode;
    String state;
    String latitude;
    String longitude;
    UserStatus status;

}
