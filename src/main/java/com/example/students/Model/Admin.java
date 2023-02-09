package com.example.students.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Admins")
public class Admin {
    @Id
    @Column(name = "Id",columnDefinition = "varchar(36)")
    private String id;

    @OneToOne
    @JoinColumn(name = "UserId")
    private User user;

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
