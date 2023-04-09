package com.example.students.repositories;

import com.example.students.models.PendingUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PendingUpdateRepository extends JpaRepository<PendingUpdate, String> {

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

    @Query(value = "SELECT " +
            "p.Id, " +
            "p.Username, " +
            "p.[Password], " +
            "p.Email, " +
            "p.FirstName, " +
            "p.LastName, " +
            "p.ChangesMade, " +
            "p.Salt, " +
            "p.AdminId, " +
            "p.UserId " +
            "FROM PendingUpdates p " +
            "INNER JOIN Users u " +
            "ON u.Id = p.UserId " +
            "WHERE u.SchoolId=:schoolId ",nativeQuery = true)
    List<PendingUpdate> findAllBySchoolId(String schoolId);
}
