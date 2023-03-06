package com.example.students.services;

import com.example.students.models.Project;
import com.example.students.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    public Project insertProject(Project project){
        return projectRepository.save(project);
    }

    public void deleteProject(Project project){
        projectRepository.delete(project);
    }

    public Project findById(String id){
        return projectRepository.findById(id).orElse(null);
    }
    public Iterable<Project> findAllByAdminId(String id){
        return projectRepository.findAllByAdmin_Id(id);
    }
}
