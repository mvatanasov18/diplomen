package com.example.students.models;

import com.example.students.services.PasswordHasher;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Entity
@Table(name = "Users")

@EqualsAndHashCode
public class User {
    @Id
    @Column(name = "id", columnDefinition = "varchar(36)")
    private final String id;

    @Column(name = "username", columnDefinition = "varchar(150)")
    private String username;

    @Column(name = "password", columnDefinition = "varchar(255)")
    private String password;

    @Column(name = "email", columnDefinition = "varchar(255)", unique = true)
    private String email;
    @Column(name = "first_name", columnDefinition = "nvarchar(100)")
    private String firstName;
    @Column(name = "last_name", columnDefinition = "nvarchar(100)")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;



    public User() {
        id = UUID.randomUUID().toString();
        username="";
        password="";
        email="";
        firstName="";
        lastName="";
        school=new School();

    }

    public User(String id, String username, String password, String email, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String id, String username, String password, String email, String firstName, String lastName, School school) {
        this(id, username, password, email, firstName, lastName);
        this.school = school;
    }



    public User(String id, String username, String password, String email, String firstName, String lastName, School school, Session session) {
        this(id, username, password, email, firstName, lastName, school);

    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", school=" + school +
                '}';
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
        this.password = PasswordHasher.hashPassword(password);
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
