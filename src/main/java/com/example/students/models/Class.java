package com.example.students.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "classes")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "grade")
    private Short grade;

    @Column(name = "letter")
    private Character letter;

    @ManyToOne
    @JoinColumn(name = "teacherID")
    private Teacher teacher;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Class aClass = (Class) o;
        return id != null && Objects.equals(id, aClass.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

