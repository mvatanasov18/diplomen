package com.example.students.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "Principals")
@EqualsAndHashCode
@AllArgsConstructor
public class Principal {
    @Id
    @Column(name = "Id", columnDefinition = "varchar(36)")
    private String id;

    @Column(name = "is_verified")
    private Boolean isVerified;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Principal() {
        id = UUID.randomUUID().toString();
        isVerified = false;
        user=new User();
    }

    public String getId() {
        return id;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public Principal setVerified(Boolean verified) {
        isVerified = verified;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Principal setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return "Principal{" +
                "id='" + id + '\'' +
                ", isVerified=" + isVerified +
                ", user_id=" + user.getId() +
                '}';
    }
}
