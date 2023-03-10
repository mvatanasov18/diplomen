package com.example.students.services;


import com.example.students.models.Student;
import com.example.students.repositories.StudentRepository;
import lombok.AllArgsConstructor;
@org.springframework.stereotype.Service
@AllArgsConstructor
public class StudentService implements com.example.students.services.Service<Student>{
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
}
