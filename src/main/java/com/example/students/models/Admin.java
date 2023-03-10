package com.example.students.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "Admins")
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Admin {
    @Id
    @Column(name = "id", columnDefinition = "varchar(36)")
    private String id;

    @OneToOne
    @JoinColumn(name = "user_Id")
    private User user;

    public Admin() {
        id = UUID.randomUUID().toString();
        user=new User();
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Admin setUser(User user) {
        this.user = user;
        return this;
    }
}
