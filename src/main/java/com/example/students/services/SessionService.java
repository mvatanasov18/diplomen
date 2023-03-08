package com.example.students.services;

import com.example.students.models.Session;
import com.example.students.repositories.SessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SessionService {
    private final SessionRepository sessionRepository;

    public Session saveSession(Session session){
        return sessionRepository.save(session);
    }
    public void deleteSession(Session session){
        sessionRepository.delete(session);
    }

    public Session findById(String id){
        return sessionRepository.findById(id).orElse(null);
    }
    public Session findByUserId(String userId){
        return sessionRepository.findByUserId(userId);
    }

}
