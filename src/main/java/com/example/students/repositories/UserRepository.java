package com.example.students.repositories;

import com.example.students.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    public User findByUsername(String username);
    public Boolean existsByEmail(String email);
    public Boolean existsByUsername(String username);
}
