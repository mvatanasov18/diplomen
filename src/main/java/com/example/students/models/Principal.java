package com.example.students.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Principals")
public class Principal {
    @Id
    @Column(name = "Id",columnDefinition = "varchar(36)")
    private  String id;

    @Column(name="IsVerified")
    private Boolean isVerified;
    @OneToOne
    @JoinColumn(name = "UserId")
    private User user;

    public Principal() {
        id= UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
