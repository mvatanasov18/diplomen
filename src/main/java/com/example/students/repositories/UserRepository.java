package com.example.students.repositories;

import com.example.students.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);
}
