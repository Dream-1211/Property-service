package com.coderboost.propertyservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PropertyImageRequestDto {
    String name;
    String type;
    byte[] data;
}
