package com.example.students.services;

import com.example.students.models.Admin;
import com.example.students.models.FileEntity;
import com.example.students.repositories.AdminRepository;
import com.example.students.repositories.FileEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class FileEntityService implements com.example.students.services.Service<FileEntity> {
    private final FileEntityRepository fileEntityRepository;

    public FileEntity save(FileEntity fileEntity){
        return fileEntityRepository.save(fileEntity);
    }
    public void delete(FileEntity fileEntity){
        fileEntityRepository.delete(fileEntity);
    }
    public FileEntity findById(String id){
        return fileEntityRepository.findById(id).orElse(null);
    }
    public Iterable<FileEntity> findAll(){
        return fileEntityRepository.findAll();
    }
}
