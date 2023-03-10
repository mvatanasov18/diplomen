package com.example.students.services;

import com.example.students.models.School;
import com.example.students.repositories.SchoolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SchoolService implements com.example.students.services.Service<School> {
    private final SchoolRepository schoolRepository;
    @Override
    public School save(School school){
        return schoolRepository.save(school);
    }
    @Override
    public void delete(School school){
        schoolRepository.delete(school);
    }
    @Override
    public School findById(String id){
        return schoolRepository.findById(id).orElse(null);
    }
   @Override
    public Iterable<School> findAll(){
        return schoolRepository.findAll();
    }
}
