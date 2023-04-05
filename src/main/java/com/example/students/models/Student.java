package com.example.students.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Students")
@AllArgsConstructor
@EqualsAndHashCode
public class Student {
    @Id
    @Column(name = "Id", nullable = false, columnDefinition = "varchar(36)")
    private String id;

    @OneToOne
    @JoinColumn(name = "UserId", columnDefinition = "varchar(36)")
    private User user;

    @ManyToMany
    @JoinTable(name = "StudentsTeams", joinColumns = @JoinColumn(name = "StudentId"), inverseJoinColumns = @JoinColumn(name = "TeamId"))
    private Set<Team> teams;

    @ManyToOne
    @JoinColumn(name = "GroupId", nullable = false)
    private Group group;

    @ManyToMany
    @JoinTable(name = "StudentsTasks", joinColumns = @JoinColumn(name = "StudentId"), inverseJoinColumns = @JoinColumn(name = "TaskId"))
    private Set<Task> tasks;

    public Student() {
        id = UUID.randomUUID().toString();
        user = new User();
        teams=new HashSet<>();
        group=new Group();
        tasks=new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Student setTasks(Set<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

    public Group getGroup() {
        return group;
    }

    public Student setGroup(Group group) {
        this.group = group;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Student setUser(User user) {
        this.user = user;
        return this;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public Student setTeams(Set<Team> teams) {
        this.teams = teams;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", group_id=" + group.getId() +
                '}';
    }
}
