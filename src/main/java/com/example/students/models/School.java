package com.example.students.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "Schools")
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class School {
    @Id
    @Column(name = "Id", columnDefinition = "varchar(36) NOT NULL")
    private String id;
    @Column(name = "Name", columnDefinition = "nvarchar(255) NOT NULL")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AddressId", referencedColumnName = "Id")
    private Address address;

    public School() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public School setName(String name) {
        this.name = name;
        return this;
    }

    public Address getAddress() {
        return address;

    }

    public School setAddress(Address address) {
        this.address = address;
        return this;
    }
}
