package com.example.students.services;

import com.example.students.models.Session;
import com.example.students.repositories.SessionJdbcTemplateRepository;
import com.example.students.repositories.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;
    private final SessionJdbcTemplateRepository sessionJdbcTemplateRepository;

    public SessionService(SessionRepository sessionRepository,
                          SessionJdbcTemplateRepository sessionJdbcTemplateRepository){
        this.sessionRepository=sessionRepository;
        this.sessionJdbcTemplateRepository=sessionJdbcTemplateRepository;
    }
    public int saveSession(Session session){
        return sessionJdbcTemplateRepository.saveSession(session);
    }
    public void deleteSession(Session session){
        sessionRepository.delete(session);
    }

    public Session findById(String id){
        return sessionRepository.findById(id).orElse(null);
    }
}
