package com.example.students.repositories;

import com.example.students.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    public User findByUsername(String username);
}
