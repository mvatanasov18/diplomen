package com.example.students.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Teachers")
@AllArgsConstructor
@EqualsAndHashCode
public class Teacher {
    @Id
    @Column(name = "Id", unique = true, nullable = false, columnDefinition = "varchar(36)")
    private String id;

    @OneToOne
    @JoinColumn(name = "User_Id", columnDefinition = "varchar(36)")
    private User user;

    @OneToMany(mappedBy = "teacher")
    private Set<Task> tasks;

    @OneToOne(mappedBy = "teacher")
    private Group group;

    public Teacher() {
        id = UUID.randomUUID().toString();
        user = new User();
        tasks = new HashSet<>();
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", tasks=" + tasks +
                '}';
    }
}
