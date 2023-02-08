package com.coderboost.propertyservice.entity;

import com.coderboost.propertyservice.enums.OfferStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

import static com.coderboost.propertyservice.enums.OfferStatus.AVAILABLE;

@Entity
@Table(name = "property_offers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropertyOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    Owner owner;

    @OneToOne
    @JoinColumn(name = "property_id")
    Property property;

    @Enumerated(EnumType.STRING)
    OfferStatus status = AVAILABLE;

    Instant createdAt;

    Instant updatedAt;

    double amount;
}
