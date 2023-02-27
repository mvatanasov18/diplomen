package com.example.students.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "Parents")
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Parent {
    @Id
    @Column(name = "Id", nullable = false, columnDefinition = "varchar(36)")
    private String id;

    @Column(name = "First_Name", columnDefinition = "nvarchar(100)", nullable = false)
    private String firstName;

    @Column(name = "Last_Name", columnDefinition = "nvarchar(100)", nullable = false)
    private String lastName;

    @Column(name = "Email", columnDefinition = "varchar(255)", nullable = false)
    private String email;

    @Column(name = "Phone_Number", columnDefinition = "varchar(10)", nullable = false)
    private String phoneNumber;
    @OneToOne
    @JoinColumn(name = "Address_Id", columnDefinition = "varchar(36)")
    private Address address;

    public Parent() {
        id = UUID.randomUUID().toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public Parent setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Parent setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Parent setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Parent setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Parent setAddress(Address address) {
        this.address = address;
        return this;
    }
}
