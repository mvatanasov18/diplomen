package com.example.students.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "Sessions")
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Session {
    @Id
    private String id;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "time_created")
    private Timestamp timeCreated;
    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public Session() {
        id = UUID.randomUUID().toString();
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

    public Timestamp getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Timestamp timeCreated) {
        this.timeCreated = timeCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
