package com.example.students.repositories;

import com.example.students.models.PendingUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PendingUpdateRepository extends JpaRepository<PendingUpdate, String> {
}
