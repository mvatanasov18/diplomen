package com.example.students.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Projects")
public class Project {
    @Id
    @Column(name = "Id",nullable = false,columnDefinition = "varchar(36)")
    private String id;
}
