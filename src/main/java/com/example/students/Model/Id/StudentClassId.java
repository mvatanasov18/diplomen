package com.example.students.Model.Id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StudentClassId implements Serializable {
    private Integer studentId;
    private Integer groupId;
}
