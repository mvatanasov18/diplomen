package com.example.students.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "principals")
@Data
public class Principal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "userid")
    private User user;

    @Column(name = "isVerified")
    private boolean isVerified;
}

