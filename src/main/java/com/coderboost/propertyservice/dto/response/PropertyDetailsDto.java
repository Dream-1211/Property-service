package com.coderboost.propertyservice.dto.response;

import com.coderboost.propertyservice.entity.PropertyImage;
import com.coderboost.propertyservice.enums.PropertyCategory;
import com.coderboost.propertyservice.enums.PropertyStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PropertyDetailsDto {

    String name;
    String detail;
    PropertyCategory category;
    PropertyStatus status;
    boolean isActive;

    String address;
    String latitude;
    String longitude;
    List<PropertyImagesDto> images;


}
