package com.coderboost.propertyservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "property_location")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String address;
    String latitude;
    String longitude;

    public PropertyLocation(String address, String latitude, String longitude) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
