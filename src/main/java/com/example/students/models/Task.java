package com.example.students.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Tasks")
public class Task {
    @Id
    @Column(name = "Id",columnDefinition = "varchar(36)",nullable = false,unique = true)
    private String id;
    @Column(name = "Name",columnDefinition = "nvarchar(255)")
    private String name;
    @Column(name = "Description",columnDefinition = "nvarchar(max)")
    private String description;
    @Column(name="DateCreated",columnDefinition = "datetime2(0)")
    private LocalDateTime dateCreated;
    @Column(name="DueDate",columnDefinition = "datetime2(0) CHECK(DateCreated<=DueDate)")
    private LocalDateTime dueDate;

 @ManyToMany
 @JoinTable(
         name = "StudentsTasks",
         joinColumns = @JoinColumn(name = "TaskId"),
         inverseJoinColumns = @JoinColumn(name = "StudentId")
 )
 private Set<Student> students;
    @ManyToOne
    @JoinColumn(name = "TeacherId",nullable = false)
    private Teacher teacher;

}
