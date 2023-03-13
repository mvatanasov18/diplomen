package com.example.students.repositories;

import com.example.students.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
    Teacher findTeacherByUserId(String userId);
    @Query( value="SELECT t.id, t.[user_id] FROM Teachers AS t " +
            "LEFT JOIN Groups AS g ON t.id=g.teacher_id " +
            "INNER JOIN Users AS u ON t.[user_id] = u.id " +
            "WHERE u.school_id = :id",nativeQuery = true)
    List<Teacher> findAllNotAssignedToClassBySchoolId( @Param("id") String id);
}
