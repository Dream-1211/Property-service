package com.coderboost.propertyservice.entity;


import com.coderboost.propertyservice.enums.UserStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "owner")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    long userId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    Address address;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    UserStatus status = UserStatus.INACTIVE;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    List<Property> property;

    @OneToMany(mappedBy = "owner")
    List<PropertyOffer> offers;


    public Owner(String name, long userId, Address address, List<Property> properties) {
        this.name = name;
        this.userId = userId;
        this.address = address;
        this.property = properties;
    }
}
