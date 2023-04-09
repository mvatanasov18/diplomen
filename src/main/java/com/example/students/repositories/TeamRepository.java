package com.example.students.repositories;

import com.example.students.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, String> {
    @Query(value="SELECT " +
            "t.Id " +
            "t.[Name] " +
            "FROM Teams t " +
            "INNER JOIN StudentsTeams st " +
            "ON st.TeamId = t.Id " +
            "INNER JOIN Students s " +
            "ON s.Id=st.StudentId " +
            "INNER JOIN Users u " +
            "ON u.Id = s.UserId " +
            "WHERE u.SchoolId =:id ",nativeQuery = true)
    List<Team> findAllBySchoolId(String id);
}
