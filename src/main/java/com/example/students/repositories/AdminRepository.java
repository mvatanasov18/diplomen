package com.example.students.repositories;

import com.example.students.models.Admin;
import com.example.students.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, String> {
    Admin findAdminByUserId(String userId);

    @Query(value = "SELECT " +
            "a.Id, " +
            "a.UserId " +
            "FROM Admins AS a " +
            "INNER JOIN  Users AS u " +
            "ON u.Id=a.UserId " +
            "WHERE u.SchoolId=:id ",nativeQuery = true)
    List<Admin> findAllBySchoolId(@Param("id")String id);
}
