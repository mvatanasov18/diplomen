package com.example.students.models;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Teams")
public class Team {
    @Id
    @Column(name = "Id",nullable = false,columnDefinition = "varchar(36)")
    private String id;

    @Column(name = "Name",nullable = false,columnDefinition = "nvarchar(100)")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "TeamsProjects",
            joinColumns = @JoinColumn(name = "TeamId"),
            inverseJoinColumns = @JoinColumn(name = "ProjectId")
    )
    private Set<Project> projects;

    @ManyToMany
    @JoinTable(
            name = "StudentsTeams",
            joinColumns = @JoinColumn(name = "TeamId"),
            inverseJoinColumns = @JoinColumn(name = "StudentId")
    )
    private Set<Student> students;


    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Team() {
        id= UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
