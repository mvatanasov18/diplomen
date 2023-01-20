package com.example.students.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Grade")
    private Short grade;
    @Column(name = "Letter")
    private Character letter;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TeacherID")
    private Teacher teacher;
}
