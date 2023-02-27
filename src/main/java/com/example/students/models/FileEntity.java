package com.example.students.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "Files")
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class FileEntity {
    @Id
    @Column(name = "Id",columnDefinition = "varchar(36)",nullable = false,unique = true)
    private String id;
    @Column(name = "FileContent",columnDefinition = "varbinary(max)",nullable = false)
    private byte[] fileContent;

    @ManyToOne
    @JoinColumn(name = "TaskId",nullable = false)
    private Task task;

    public FileEntity() {
        id= UUID.randomUUID().toString();
    }



    public String getId() {
        return id;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public FileEntity setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
        return this;
    }

    public Task getTask() {
        return task;
    }

    public FileEntity setTask(Task task) {
        this.task = task;
        return this;
    }
}
