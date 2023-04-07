package com.example.students.services;


import com.example.students.models.Student;
import com.example.students.models.Teacher;
import com.example.students.repositories.StudentRepository;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class StudentService implements com.example.students.services.Service<Student> {
    private final StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public Student findById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findByUserId(String id) {
        return studentRepository.findStudentByUserId(id);
    }

    public List<Student> findAllBySchoolId(String schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }

    public void deleteById(String id){
        studentRepository.deleteById(id);
    }

    public boolean checkStudentByIdAndSchoolId(String id, String schoolId) {
        List<Student> students = findAllBySchoolId(schoolId);
        Map<String, Student> hashTeachers = new HashMap<>();

        for (Student student : students) {
            hashTeachers.put(student.getId(), student);
        }

        return hashTeachers.containsKey(id);
    }
}
