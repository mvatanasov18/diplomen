package com.example.students.repositories;

import com.example.students.models.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, String> {
}
