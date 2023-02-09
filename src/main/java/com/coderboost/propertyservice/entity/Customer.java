package com.coderboost.propertyservice.entity;


import com.coderboost.propertyservice.enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    long userId;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    UserStatus status = UserStatus.ACTIVE;

    @OneToMany(mappedBy = "customer")
    List<PropertyOffer> offer;

    public Customer(String name, long userId) {
        this.name = name;
        this.userId = userId;
    }
}
