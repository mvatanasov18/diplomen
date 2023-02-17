package com.example.students.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Projects")
public class Project {
    @Id
    @Column(name = "Id",nullable = false,columnDefinition = "varchar(36)")
    private String id;

    @Column(name = "Name",columnDefinition = "nvarchar(255)",nullable = false)
    private String name;

    @Column(name = "Description",columnDefinition = "nvarchar(MAX)",nullable = false)
    private String description;

    @Column(name = "DateCreated",columnDefinition = "datetime2(0)",nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "DueDate",columnDefinition = "datetime2(0)",nullable = true)
    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "AdminId",columnDefinition = "varchar(36)")
    private Admin admin;

    @ManyToMany
    @JoinTable(
            name = "TeamsProjects",
            joinColumns = @JoinColumn(name = "ProjectId"),
            inverseJoinColumns = @JoinColumn(name = "TeamId")
    )
    private Set<Team> teams;

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Project() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
