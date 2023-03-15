package com.example.students.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Arrays;
import java.util.UUID;

@Entity
@Table(name = "Files")
@EqualsAndHashCode
@AllArgsConstructor
public class FileEntity {
    @Id
    @Column(name = "Id", columnDefinition = "varchar(36)", nullable = false, unique = true)
    private String id;
    @Column(name = "File_Content", columnDefinition = "varbinary(max)", nullable = false)
    private byte[] fileContent;

    @ManyToOne
    @JoinColumn(name = "Task_Id", nullable = false)
    private Task task;

    public FileEntity() {
        id = UUID.randomUUID().toString();
        fileContent=new byte[0];
        task=new Task();
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

    @Override
    public String toString() {
        return "FileEntity{" +
                "id='" + id + '\'' +
                ", fileContent=" + Arrays.toString(fileContent) +
                ", task_id=" + task.getId() +
                '}';
    }
}
