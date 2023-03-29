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
    private String roleName;
    @Column(name = "time_created")
    private LocalDateTime timeCreated;
    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public Session() {
        id = UUID.randomUUID().toString();
        roleName="";
        timeCreated=LocalDateTime.now();
        user=new User();
    }

    public String getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
