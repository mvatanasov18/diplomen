package com.example.students.Model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "Users")
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Username",length = 100,unique = true)
    private String username;
    @Column(name = "Password")
    private String password;
    @Column(name = "FirstName",length = 100)
    private String firstName;
    @Column(name = "LastName",length = 100)
    private String lastName;
    @Column(name = "Email",length = 100,unique = true)
    private String email;
    @ManyToOne
    @JoinColumn(name = "SchoolID")
    private School school;
}
