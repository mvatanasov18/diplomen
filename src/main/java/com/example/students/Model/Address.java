package com.example.students.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "Addresses")
public class Address {
    @Id
    @Column(name = "Id", columnDefinition = "varchar(36) NOT NULL")
    private String id;
    @Column(name = "City", columnDefinition = "nvarchar(100) NOT NULL")
    private String city;
    @Column(name = "HouseNumber", columnDefinition = "int CHECK(HouseNumber>0) NOT NULL")
    private Integer houseNumber;
    @Column(name = "Street", columnDefinition = "nvarchar(100) NOT NULL")
    private String street;
    @Column(name = "AdditionalInfo",columnDefinition = "nvarchar(100)")
    private String additionalInfo;

    public Address() {
        this.id= UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
