package com.example.students.models;

import com.example.students.services.PasswordHasher;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.UUID;

@Entity
@Table(name = "Users")

@EqualsAndHashCode
@ToString
public class User {
    @Id
    @Column(name = "Id",columnDefinition = "varchar(36)")
    private String id;

    @Column(name = "Username",columnDefinition = "varchar(150)")
    private String username;

    @Column(name = "Password",columnDefinition = "varchar(255)")
    private String password;

    @Column(name = "Email",columnDefinition = "varchar(255)",unique = true)
    private String email;
    @Column(name = "First_Name",columnDefinition = "nvarchar(100)")
    private String firstName;
    @Column(name = "Last_Name",columnDefinition = "nvarchar(100)")
    private String lastName;

    @Column(name = "Auth_Token",columnDefinition = "nvarchar(100)")
    private String authToken;

    @ManyToOne
    @JoinColumn(name = "School_Id")
    private School school;

    public User() {
        id= UUID.randomUUID().toString();
    }

    public User(String id, String username, String password, String email, String firstName, String lastName, School school,String authToken) {
        this.id = id;
        this.username = username;
        this.setPassword(password);
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
        this.authToken=authToken;
    }

    public String getId() {
        return id;
    }


    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
     this.password= PasswordHasher.hashPassword(password);
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public School getSchool() {
        return school;
    }

    public User setSchool(School school) {
        this.school = school;
        return this;
    }
}
