package com.example.students.Model;

import com.example.students.Model.Id.StudentClassId;
import jakarta.persistence.*;

@Entity
@Table(name = "StudentsClasses")
public class StudentClass {
@EmbeddedId
private StudentClassId id;
    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "class_id", insertable = false, updatable = false)
    private Group group;
}
