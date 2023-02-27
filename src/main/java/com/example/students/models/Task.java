package com.example.students.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Tasks")
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Task {
    @Id
    @Column(name = "Id", columnDefinition = "varchar(36)", nullable = false, unique = true)
    private String id;
    @Column(name = "Name", columnDefinition = "nvarchar(255)")
    private String name;
    @Column(name = "Description", columnDefinition = "nvarchar(max)")
    private String description;
    @Column(name = "DateCreated", columnDefinition = "datetime2(0)")
    private LocalDateTime dateCreated;
    @Column(name = "DueDate", columnDefinition = "datetime2(0) CHECK(DateCreated<=DueDate)")
    private LocalDateTime dueDate;

    @ManyToMany
    @JoinTable(name = "StudentsTasks", joinColumns = @JoinColumn(name = "TaskId"), inverseJoinColumns = @JoinColumn(name = "StudentId"))
    private Set<Student> students;
    @ManyToOne
    @JoinColumn(name = "TeacherId", nullable = false)
    private Teacher teacher;

    public Task() {
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Task setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public Task setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Task setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Task setStudents(Set<Student> students) {
        this.students = students;
        return this;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Task setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }
}
