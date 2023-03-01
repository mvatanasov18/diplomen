package com.example.students.repositories;

import com.example.students.models.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SessionJdbcTemplateRepository {

    private final JdbcTemplate jdbc;
    public SessionJdbcTemplateRepository(JdbcTemplate jdbc){
        this.jdbc=jdbc;
    }
    public int saveSession(Session session) {
        String query = "INSERT INTO Sessions(session_id,role_name,user_id) " +
                "VALUES(?,?,?)";
       return jdbc.update(query, session.getSessionId(),
                session.getRoleName(), session.getUser().getId());
    }
}
