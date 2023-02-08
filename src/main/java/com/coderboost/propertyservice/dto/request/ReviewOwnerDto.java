package com.coderboost.propertyservice.dto.request;

import com.coderboost.propertyservice.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewOwnerDto {
    long id;
    UserStatus status;
}
