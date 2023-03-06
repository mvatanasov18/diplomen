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
public class FileEntityService {
    private final FileEntityRepository fileEntityRepository;

    public FileEntity saveFileEntity(FileEntity fileEntity){
        return fileEntityRepository.save(fileEntity);
    }
    public void deleteFileEntity(FileEntity fileEntity){
        fileEntityRepository.delete(fileEntity);
    }
    public FileEntity findById(String id){
        return fileEntityRepository.findById(id).orElse(null);
    }
    public Iterable<FileEntity> findAll(){
        return fileEntityRepository.findAll();
    }
}
