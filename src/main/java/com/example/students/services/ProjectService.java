package com.example.students.services;

import com.example.students.models.Project;
import com.example.students.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectService implements com.example.students.services.Service<Project> {
    private final ProjectRepository projectRepository;
    @Override
    public Project save(Project project){
        return projectRepository.save(project);
    }
@Override
    public void delete(Project project){
        projectRepository.delete(project);
    }
@Override
    public Project findById(String id){
        return projectRepository.findById(id).orElse(null);
    }
    public Iterable<Project> findAllByAdminId(String id){
        return projectRepository.findAllByAdmin_Id(id);
    }
    @Override
    public Iterable<Project> findAll(){
        return projectRepository.findAll();
    }
}
