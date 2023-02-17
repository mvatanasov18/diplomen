package com.example.students.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Parents")
public class Parent {
    @Id
    @Column(name = "Id",nullable = false,columnDefinition = "varchar(36)")
    private String id;

    @Column(name = "FirstName",columnDefinition = "nvarchar(100)",nullable = false)
    private String firstName;

    @Column(name = "LastName",columnDefinition = "nvarchar(100)",nullable = false)
    private String lastName;

    @Column(name = "Email",columnDefinition = "varchar(255)",nullable = false)
    private String email;

    @Column(name = "PhoneNumber",columnDefinition = "varchar(10)",nullable = false)
    private String phoneNumber;
    @OneToOne
    @JoinColumn(name = "AddressId",columnDefinition = "varchar(36)")
    private Address address;
}
