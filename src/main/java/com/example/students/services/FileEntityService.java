package com.example.students.services;

import com.example.students.models.FileEntity;
import com.example.students.repositories.FileEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class FileEntityService implements com.example.students.services.Service<FileEntity> {
    private final FileEntityRepository fileEntityRepository;

    @Override
    public FileEntity save(FileEntity fileEntity) {
        return fileEntityRepository.save(fileEntity);
    }

    @Override
    public void delete(FileEntity fileEntity) {
        fileEntityRepository.delete(fileEntity);
    }

    @Override
    public FileEntity findById(String id) {
        return fileEntityRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<FileEntity> findAll() {
        return fileEntityRepository.findAll();
    }
}
