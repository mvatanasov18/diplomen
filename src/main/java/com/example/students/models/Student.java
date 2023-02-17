package com.example.students.models;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @Column(name = "Id",nullable = false,columnDefinition = "varchar(36)")
    private String id;

    @OneToOne
    @JoinColumn(name = "UserId",columnDefinition = "varchar(36)")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ParentId",columnDefinition = "varchar(36)")
    private Parent parent;

    @ManyToMany
    @JoinTable(name = "StudentsTeams", joinColumns = @JoinColumn(name = "StudentId"),
    inverseJoinColumns = @JoinColumn(name = "TeamId"))
    private Set<Team> teams;

    @ManyToOne
    @JoinColumn(name = "GroupId",nullable = false)
    private Group group;

    @ManyToMany
    @JoinTable(
            name = "StudentsTasks",
            joinColumns = @JoinColumn(name = "StudentId"),
            inverseJoinColumns = @JoinColumn(name = "TaskId")
    )
    private Set<Task> tasks;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Student() {
        id= UUID.randomUUID().toString();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
