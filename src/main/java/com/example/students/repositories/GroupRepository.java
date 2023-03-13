package com.example.students.repositories;

import com.example.students.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, String> {
    @Query(value="SELECT " +
            "g.id, " +
            "g.grade, " +
            "g.letter, " +
            "g.teacher_id " +
            "FROM Groups AS g " +
            "INNER JOIN Teachers AS t " +
            "ON t.id = g.teacher_id " +
            "INNER JOIN Users AS u " +
            "ON u.id = t.[user_id] " +
            "WHERE u.school_id = :id ",nativeQuery = true)
    List<Group> findAllBySchoolId(String id);
}
