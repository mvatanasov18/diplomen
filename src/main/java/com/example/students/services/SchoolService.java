package com.example.students.services;

import com.example.students.models.Admin;
import com.example.students.models.School;
import com.example.students.repositories.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository){
        this.schoolRepository=schoolRepository;
    }

    public School saveSchool(School school){
        return schoolRepository.save(school);
    }
    public void deleteSchool(School school){
        schoolRepository.delete(school);
    }
    public School findById(String id){
        return schoolRepository.findById(id).orElse(null);
    }
    public Iterable<School> findAll(){
        return schoolRepository.findAll();
    }
}
