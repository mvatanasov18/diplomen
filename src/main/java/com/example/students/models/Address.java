package com.example.students.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Entity
@Table(name = "Addresses")
@AllArgsConstructor
@EqualsAndHashCode
public class Address {
    @Id
    @Column(name = "id", columnDefinition = "varchar(36) NOT NULL")
    private String id;
    @Column(name = "City", columnDefinition = "nvarchar(100) NOT NULL")
    private String city;
    @Column(name = "House_Number", columnDefinition = "int CHECK(HouseNumber>0) NOT NULL")
    private Integer houseNumber;
    @Column(name = "Street", columnDefinition = "nvarchar(100) NOT NULL")
    private String street;
    @Column(name = "Additional_Info", columnDefinition = "nvarchar(100)")
    private String additionalInfo;

    public Address() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", houseNumber=" + houseNumber +
                ", street='" + street + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public Address setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public Address setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }
}
