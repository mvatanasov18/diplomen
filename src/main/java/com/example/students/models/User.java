package com.example.students.models;

import jakarta.persistence.*;

import java.util.UUID;

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

    public User() {
        id= UUID.randomUUID().toString();
    }

    public User(String id, String username, String password, String email, String firstName, String lastName, School school) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
