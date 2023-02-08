package com.coderboost.propertyservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PropertyOfferDto {
    long id;
    String propertyName;

    String propertyDetails;
    String status;
    String ownerName;

    long ownerUserId;
    Instant createdAt;
    Instant updatedAt;
    double amount;

    String customerName;

    long customerUserId;
}
