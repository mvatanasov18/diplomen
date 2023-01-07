package com.example.students.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Username", unique = true)
    private String username;

    @Column(name = "Password")
    private byte[] password;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Email", unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "SchoolID")
    private School school;
}
