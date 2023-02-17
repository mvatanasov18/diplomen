package com.example.students.models;

import jakarta.persistence.*;
@Entity
@Table(name = "Files")
public class FileEntity {
    @Id
    @Column(name = "Id",columnDefinition = "varchar(36)",nullable = false,unique = true)
    private String id;
    @Column(name = "FileContent",columnDefinition = "varbinary(max)",nullable = false)
    private byte[] fileContent;

    @ManyToOne
    @JoinColumn(name = "TaskId",nullable = false)
    private Task task;
}
