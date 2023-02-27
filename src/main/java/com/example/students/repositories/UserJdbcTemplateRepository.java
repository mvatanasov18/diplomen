package com.example.students.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcTemplateRepository {
    @Autowired
    private JdbcTemplate jdbc;
    public void saveSessionByUsername(String session, String username) {
        String query = "UPDATE Users SET Auth_Token=? WHERE username=?";
        jdbc.update(query, session, username);
    }

}
