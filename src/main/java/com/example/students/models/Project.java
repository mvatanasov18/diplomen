package com.example.students.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Projects")
@AllArgsConstructor
@EqualsAndHashCode
public class Project {
    @Id
    @Column(name = "Id", nullable = false, columnDefinition = "varchar(36)")
    private String id;

    @Column(name = "Name", columnDefinition = "nvarchar(255)", nullable = false)
    private String name;

    @Column(name = "Description", columnDefinition = "nvarchar(MAX)", nullable = false)
    private String description;

    @Column(name = "Date_Created", columnDefinition = "datetime2(0)", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "Due_Date", columnDefinition = "datetime2(0)")
    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "Admin_Id", columnDefinition = "varchar(36)")
    private Admin admin;

    @ManyToMany
    @JoinTable(name = "TeamsProjects", joinColumns = @JoinColumn(name = "Project_Id"), inverseJoinColumns = @JoinColumn(name = "Team_Id"))
    private Set<Team> teams;


    public Project() {
        id = UUID.randomUUID().toString();
        name="";
        description="";
        dateCreated=LocalDateTime.now();
        dueDate=LocalDateTime.now().plusMonths(1);
        admin=new Admin();
        teams= new HashSet<>();
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public Project setTeams(Set<Team> teams) {
        this.teams = teams;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Project setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public Project setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Project setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Admin getAdmin() {
        return admin;
    }

    public Project setAdmin(Admin admin) {
        this.admin = admin;
        return this;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                ", dueDate=" + dueDate +
                ", admin_id=" + admin.getId() +
                '}';
    }
}
