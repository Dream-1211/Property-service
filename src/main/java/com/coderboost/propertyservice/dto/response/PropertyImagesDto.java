package com.coderboost.propertyservice.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PropertyImagesDto {
    long id;
    String name;
    String type;
    byte[] data;
}
