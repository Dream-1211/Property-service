package com.coderboost.propertyservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminStatisticsDto {

    long customers;
    long properties;
    long owners;
    long offers;
}
