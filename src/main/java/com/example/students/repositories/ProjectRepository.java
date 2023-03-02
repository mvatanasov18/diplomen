package com.example.students.repositories;

import com.example.students.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, String> {
    public Iterable<Project> findAllByAdmin_Id(String id);
}
