package com.example.students.services;

import com.example.students.models.Group;
import com.example.students.models.Parent;
import com.example.students.repositories.GroupRepository;
import com.example.students.repositories.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParentService {
    private final ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository){
        this.parentRepository =parentRepository;
    }

    public Parent saveParent(Parent parent){
        return parentRepository.save(parent);
    }
    public void deleteParent(Parent parent){
        parentRepository.delete(parent);
    }
    public Parent findById(String id){
        return parentRepository.findById(id).orElse(null);
    }
    public Iterable<Parent> findAll(){
        return parentRepository.findAll();
    }
}