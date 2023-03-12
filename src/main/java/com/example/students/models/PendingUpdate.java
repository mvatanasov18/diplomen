package com.example.students.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "PendingUpdates")
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class PendingUpdate {
    @Id
    @Column(name = "Id", unique = true, nullable = false, columnDefinition = "varchar(36)")
    private String id;

    @Column(name = "Username", columnDefinition = "varchar(150)")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email", columnDefinition = "varchar(255)", unique = true)
    private String email;
    @Column(name = "First_Name", columnDefinition = "nvarchar(100)")
    private String firstName;
    @Column(name = "Last_Name", columnDefinition = "nvarchar(100)")
    private String lastName;
    @Column(name = "Changes_Made")
    private LocalDateTime changesMade;
    @ManyToOne
    @JoinColumn(name = "Admin_Id")
    private Admin admin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_Id", columnDefinition = "varchar(36)")
    private User user;

    public PendingUpdate() {
        id = UUID.randomUUID().toString();
        username="";
        password="";
        email="";
        firstName="";
        lastName="";
        changesMade=LocalDateTime.now();
        admin=new Admin();
        user=new User();
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public PendingUpdate setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public PendingUpdate setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PendingUpdate setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public PendingUpdate setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PendingUpdate setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LocalDateTime getChangesMade() {
        return changesMade;
    }

    public PendingUpdate setChangesMade(LocalDateTime changesMade) {
        this.changesMade = changesMade;
        return this;
    }

    public Admin getAdmin() {
        return admin;
    }

    public PendingUpdate setAdmin(Admin admin) {
        this.admin = admin;
        return this;
    }

    public User getUser() {
        return user;
    }

    public PendingUpdate setUser(User user) {
        this.user = user;
        return this;
    }
}
