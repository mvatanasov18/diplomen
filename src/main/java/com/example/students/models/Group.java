package com.example.students.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.type.descriptor.jdbc.NCharJdbcType;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Groups")
@AllArgsConstructor
@EqualsAndHashCode
public class Group {
    @Id
    @Column(name = "Id", unique = true, nullable = false, columnDefinition = "varchar(36)")
    private String id;

    @Column(name = "Grade", columnDefinition = "tinyint CHECK(Grade IN (2,3,4,5,6))")
    private Integer grade;

    @Column(name = "Letter", columnDefinition = "nchar")
    private char letter;

    @OneToOne
    @JoinColumn(name = "Teacher_Id", columnDefinition = "varchar(36)")
    private Teacher teacher;
    @OneToMany(mappedBy = "group")
    private Set<Student> students;

    public Group() {
        id = UUID.randomUUID().toString();
        grade=1;
        letter='a';
        teacher=new Teacher();
        students=new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public Group setGrade(int grade) {
        this.grade = grade;
        return this;
    }

    public char getLetter() {
        return letter;
    }

    public Group setLetter(char letter) {
        this.letter = letter;
        return this;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Group setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Group setStudents(Set<Student> students) {
        this.students = students;
        return this;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                ", grade=" + grade +
                ", letter=" + letter +
                ", teacher=" + teacher +
                '}';
    }
}
