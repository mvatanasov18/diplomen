package com.example.students.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "City", length = 100)
    private String city;
    @Column(name = "Country", length = 100)
    private String country;
    @Column(name = "HouseNumber")
    private Short houseNumber;
    @Column(name = "Street", length = 100)
    private String street;
    @Column(name = "AdditionalInfo", length = 100)
    private String additionalInfo;
}
