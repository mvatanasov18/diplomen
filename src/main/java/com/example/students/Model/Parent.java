package com.example.students.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Parents")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FirstName",length = 100)
    private String firstName;

    @Column(name = "LastName",length = 100)
    private String lastName;

    @Column(name = "Email",length = 255)
    private String email;

    @Column(name="PhoneNumber",length = 11)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="AddressID")
    private Address address;
}
