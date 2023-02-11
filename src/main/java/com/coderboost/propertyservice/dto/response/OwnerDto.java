package com.coderboost.propertyservice.dto.response;

import com.coderboost.propertyservice.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class OwnerDto {
    long id;
    String name;
    long userId;
    String street;
    String zipCode;
    String state;
    UserStatus status;

    boolean hasProperties;
}
