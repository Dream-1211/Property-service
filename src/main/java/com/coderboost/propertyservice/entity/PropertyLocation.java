package com.coderboost.propertyservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "property_location")
@Data
public class PropertyLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String address;
    String latitude;
    String longitude;
}
