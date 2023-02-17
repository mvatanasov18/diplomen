package com.example.students.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Teachers")
public class Teacher {
    @Id
    @Column(name = "Id",unique = true,nullable = false,columnDefinition = "varchar(36)")
    private String id;

    @OneToOne
    @JoinColumn(name = "UserId",columnDefinition = "varchar(36)")
    private User user;

    @OneToMany(mappedBy = "teacher")
    private Set<Task> tasks;

}
