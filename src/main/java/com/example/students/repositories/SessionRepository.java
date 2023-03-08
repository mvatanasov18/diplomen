package com.example.students.repositories;

import com.example.students.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, String> {
    public Session findByUserId(String id);
}
