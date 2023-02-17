package com.example.students.models;

import jakarta.persistence.*;
import org.hibernate.type.descriptor.jdbc.NCharJdbcType;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import java.util.Set;

@Entity
@Table(name = "Groups")
public class Group {
    @Id
    @Column(name = "Id",unique = true,nullable = false,columnDefinition = "varchar(36)")
    private String id;

    @Column(name = "Grade",columnDefinition = "tinyint CHECK(Grade IN (2,3,4,5,6))")
    private TinyIntJdbcType Grade;

    @Column(name = "Letter",columnDefinition = "nchar")
    private NCharJdbcType letter;

    @OneToOne
    @JoinColumn(name = "TeacherId",columnDefinition = "varchar(36)")
    private Teacher teacher;
    @OneToMany(mappedBy = "group")
    private Set<Student> students;


    public String getId() {
        return id;
    }

    public TinyIntJdbcType getGrade() {
        return Grade;
    }

    public void setGrade(TinyIntJdbcType grade) {
        Grade = grade;
    }

    public NCharJdbcType getLetter() {
        return letter;
    }

    public void setLetter(NCharJdbcType letter) {
        this.letter = letter;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
