package com.example.students.repositories;

import com.example.students.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, String> {
    @Query(value="SELECT " +
            "g.Id, " +
            "g.Grade, " +
            "g.Letter, " +
            "g.TeacherId " +
            "FROM Groups AS g " +
            "INNER JOIN Teachers AS t " +
            "ON t.Id = g.TeacherId " +
            "INNER JOIN Users AS u " +
            "ON u.Id = t.[UserId] " +
            "WHERE u.SchoolId = :id ",nativeQuery = true)
    List<Group> findAllBySchoolId(String id);

}
