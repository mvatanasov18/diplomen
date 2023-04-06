package com.example.students.repositories;

import com.example.students.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, String> {

    Teacher findTeacherByUserId(String userId);

    @Query( value="SELECT " +
            "t.Id, " +
            "t.UserId " +
            "FROM Teachers AS t " +
            "LEFT JOIN Groups g  " +
            "ON t.Id = g.TeacherId " +
            "INNER JOIN Users AS u " +
            "ON u.Id = t.UserId " +
            "WHERE g.TeacherId IS NULL AND t.Id IN  " +
            "(SELECT t.Id " +
            "FROM Teachers AS t " +
            "INNER JOIN Users AS u " +
            "ON t.UserId = u.Id " +
            "WHERE u.SchoolId=:id)",nativeQuery = true)
    List<Teacher> findAllNotAssignedToClassBySchoolId( @Param("id") String id);

    @Query(value = "SELECT " +
            "t.Id, " +
            "t.UserId " +
            "FROM Teachers AS t " +
            "INNER JOIN  Users AS u " +
            "ON u.Id=t.UserId " +
            "WHERE u.SchoolId=:id ",nativeQuery = true)
    List<Teacher> findAllBySchoolId(@Param("id")String id);
}
