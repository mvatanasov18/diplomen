package com.example.students.repositories;

import com.example.students.models.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileEntityRepository extends JpaRepository<FileEntity, String> {
}
