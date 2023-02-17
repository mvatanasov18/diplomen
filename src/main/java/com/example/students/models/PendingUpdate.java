package com.example.students.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "PendingUpdates")
public class PendingUpdate {
    @Id
    @Column(name = "Id",unique = true,nullable = false,columnDefinition = "varchar(36)")
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
    @Column(name = "ChangesMade",columnDefinition = "timestamp")
    private Timestamp changesMade;
    @ManyToOne
    @JoinColumn(name = "AdminId")
    private Admin admin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId",columnDefinition = "varchar(36)")
    private User user;

    public PendingUpdate() {
        id= UUID.randomUUID().toString();
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

    public Timestamp getChangesMade() {
        return changesMade;
    }

    public void setChangesMade(Timestamp changesMade) {
        this.changesMade = changesMade;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
