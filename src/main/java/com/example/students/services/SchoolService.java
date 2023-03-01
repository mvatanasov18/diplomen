package com.example.students.services;

import com.example.students.models.Address;
import com.example.students.models.School;
import com.example.students.repositories.AddressRepository;
import com.example.students.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;
    @Autowired
    public SchoolService(SchoolRepository schoolRepository){
        this.schoolRepository=schoolRepository;
    }

    public School saveSchool(School school){
        return schoolRepository.save(school);
    }
    public void deleteAddress(School school){
        schoolRepository.delete(school);
    }
}
