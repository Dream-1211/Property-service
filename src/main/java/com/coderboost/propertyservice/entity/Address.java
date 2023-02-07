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
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String street;
    String zipCode;
    String state;
    String latitude;
    String longitude;

    public Address(String street, String zipCode, String state, String latitude, String longitude) {
        this.street = street;
        this.zipCode = zipCode;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }


}
