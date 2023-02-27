package com.example.students.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Teachers")
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Teacher {
    @Id
    @Column(name = "Id",unique = true,nullable = false,columnDefinition = "varchar(36)")
    private String id;

    @OneToOne
    @JoinColumn(name = "User_Id",columnDefinition = "varchar(36)")
    private User user;

    @OneToMany(mappedBy = "teacher")
    private Set<Task> tasks;


    public Teacher() {
        id= UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Teacher setUser(User user) {
        this.user = user;
        return this;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Teacher setTasks(Set<Task> tasks) {
        this.tasks = tasks;
        return this;
    }
}
