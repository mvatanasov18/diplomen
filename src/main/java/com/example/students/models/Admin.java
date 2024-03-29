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
public class Admin {
    @Id
    @Column(name = "id", columnDefinition = "varchar(36)")
    private String id;

    @OneToOne
    @JoinColumn(name = "UserId")
    private User user;

    public Admin() {
        id = UUID.randomUUID().toString();
        user=new User();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", user id=" + user.getId() +
                '}';
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
