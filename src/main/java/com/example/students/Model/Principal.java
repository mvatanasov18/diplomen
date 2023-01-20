package com.example.students.Model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Principals")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Principal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserID")
    private User user;
@Column(name = "IsVerified")
    private Boolean isVerified;
}
