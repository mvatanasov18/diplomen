package com.example.students.services;

import com.example.students.models.PendingUpdate;
import com.example.students.repositories.PendingUpdateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PendingUpdateService implements com.example.students.services.Service<PendingUpdate> {
    private final PendingUpdateRepository pendingUpdateRepository;

    @Override
    public PendingUpdate save(PendingUpdate pendingUpdate) {
        return pendingUpdateRepository.save(pendingUpdate);
    }

    @Override
    public void delete(PendingUpdate pendingUpdate) {
        pendingUpdateRepository.delete(pendingUpdate);
    }

    @Override
    public PendingUpdate findById(String id) {
        return pendingUpdateRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<PendingUpdate> findAll() {
        return pendingUpdateRepository.findAll();
    }
}