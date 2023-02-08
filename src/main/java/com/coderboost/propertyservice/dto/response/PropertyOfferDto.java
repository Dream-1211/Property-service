package com.coderboost.propertyservice.dto.response;

import com.coderboost.propertyservice.entity.Customer;
import com.coderboost.propertyservice.entity.Owner;
import com.coderboost.propertyservice.entity.Property;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
