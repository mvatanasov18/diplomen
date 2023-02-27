package com.example.students.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Teams")
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Team {
    @Id
    @Column(name = "Id", nullable = false, columnDefinition = "varchar(36)")
    private String id;

    @Column(name = "Name", nullable = false, columnDefinition = "nvarchar(100)")
    private String name;

    @ManyToMany
    @JoinTable(name = "TeamsProjects", joinColumns = @JoinColumn(name = "TeamId"), inverseJoinColumns = @JoinColumn(name = "ProjectId"))
    private Set<Project> projects;

    @ManyToMany
    @JoinTable(name = "StudentsTeams", joinColumns = @JoinColumn(name = "TeamId"), inverseJoinColumns = @JoinColumn(name = "StudentId"))
    private Set<Student> students;


    public Team() {
        id = UUID.randomUUID().toString();
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Team setStudents(Set<Student> students) {
        this.students = students;
        return this;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public Team setProjects(Set<Project> projects) {
        this.projects = projects;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }
}
