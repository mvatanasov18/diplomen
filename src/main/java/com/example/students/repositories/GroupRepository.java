package com.example.students.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.students.models.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {

}

