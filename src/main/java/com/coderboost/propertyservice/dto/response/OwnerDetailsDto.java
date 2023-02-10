package com.coderboost.propertyservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OwnerDetailsDto {
    OwnerDto ownerDetails;
    PropertyDto propertyDetails;

}
