package com.example.students.services;

import com.example.students.models.Parent;
import com.example.students.models.PendingUpdate;
import com.example.students.repositories.ParentRepository;
import com.example.students.repositories.PendingUpdateRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PendingUpdateService {
    private final PendingUpdateRepository pendingUpdateRepository;

    public PendingUpdateService(PendingUpdateRepository pendingUpdateRepository){
        this.pendingUpdateRepository =pendingUpdateRepository;
    }

    public PendingUpdate savePendingUpdate(PendingUpdate pendingUpdate){
        return pendingUpdateRepository.save(pendingUpdate);
    }
    public void deletePendingUpdate(PendingUpdate pendingUpdate){
        pendingUpdateRepository.delete(pendingUpdate);
    }
    public PendingUpdate findById(String id){
        return pendingUpdateRepository.findById(id).orElse(null);
    }
    public Iterable<PendingUpdate> findAll(){
        return pendingUpdateRepository.findAll();
    }
}