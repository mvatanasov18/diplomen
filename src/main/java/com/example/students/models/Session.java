package com.example.students.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Sessions")
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Session {
    @Id
    private String id;
    @Column(name = "RoleName")
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "TimeCreated")
    private LocalDateTime timeCreated;
    @OneToOne()
    @JoinColumn(name = "UserId")
    private User user;

    public Session() {
        id = UUID.randomUUID().toString();
        role=Role.STUDENT;
        timeCreated=LocalDateTime.now();
        user=new User();
    }

    public String getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
