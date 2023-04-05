package com.example.students.models;

import com.example.students.services.PasswordHasher;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.UUID;

@Entity
@Table(name = "Users")
@EqualsAndHashCode
public class User {
    @Id
    @Column(name = "Id", columnDefinition = "varchar(36)")
    private final String id;

    @Column(name = "Username", columnDefinition = "varchar(150)")
    private String username;

    @Column(name = "Password", columnDefinition = "varchar(255)")
    private String password;

    @Column(name = "Email", columnDefinition = "varchar(255)", unique = true)
    private String email;
    @Column(name = "FirstName", columnDefinition = "nvarchar(100)")
    private String firstName;
    @Column(name = "LastName", columnDefinition = "nvarchar(100)")
    private String lastName;

    @Column(name = "Salt")
    private byte[] salt;
    @ManyToOne
    @JoinColumn(name = "SchoolId")
    private School school;


    public User() {
        id = UUID.randomUUID().toString();
        username = "";
        password = "";
        email = "";
        firstName = "";
        lastName = "";
        school = new School();

    }

    public User(String id, String username, String password, String email, String firstName, String lastName, byte[] salt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salt = salt;
    }

    public User(String id, String username, String password, String email, String firstName, String lastName, School school, byte[] salt) {
        this(id, username, password, email, firstName, lastName, salt);
        this.school = school;
    }


    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" + "id='" + id + '\'' + ", username='" + username + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", school=" + school + '}';
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void hashPassword() {
        PasswordHasher passwordHasher = new PasswordHasher();
        if (this.salt != null) {
            passwordHasher.setSalt(salt);
        }
        this.password = passwordHasher.hashPassword(password);
        this.salt = passwordHasher.getSalt();
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

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
}
