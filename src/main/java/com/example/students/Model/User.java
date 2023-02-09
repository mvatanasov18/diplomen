package com.example.students.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "Id",columnDefinition = "varchar(36)")
    private String id;

    @Column(name = "Username",columnDefinition = "varchar(150)")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email",columnDefinition = "varchar(255)",unique = true)
    private String email;
    @Column(name = "FirstName",columnDefinition = "nvarchar(100)")
    private String firstName;
    @Column(name = "LastName",columnDefinition = "nvarchar(100)")
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "SchoolId")
    private School school;
}
