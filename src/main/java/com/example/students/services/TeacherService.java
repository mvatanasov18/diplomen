package com.example.students.services;

import com.example.students.exeptions.UserNotFoundException;
import com.example.students.models.Teacher;
import com.example.students.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherService implements com.example.students.services.Service<Teacher> {
    private final TeacherRepository teacherRepository;


    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    @Override
    public Teacher findById(String id) {
        return teacherRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public Iterable<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher findByUserId(String id) {
        return teacherRepository.findTeacherByUserId(id);
    }
}
