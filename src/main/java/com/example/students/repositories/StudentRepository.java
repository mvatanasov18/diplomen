package com.example.students.repositories;

import com.example.students.models.Student;
import com.example.students.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student findStudentByUserId(String userId);
    @Query(value = "SELECT " +
            "s.Id, " +
            "s.UserId, " +
            "s.GroupId " +
            "FROM Students AS s " +
            "INNER JOIN  Users AS u " +
            "ON u.Id=s.UserId " +
            "WHERE u.SchoolId=:id ",nativeQuery = true)
    List<Student> findAllBySchoolId(@Param("id")String id);
}
