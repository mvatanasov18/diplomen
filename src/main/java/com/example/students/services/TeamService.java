package com.example.students.services;

import com.example.students.models.Team;
import com.example.students.repositories.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team insertTeam(Team team){
        return teamRepository.save(team);
    }

    public void deleteTeam (Team team){
        teamRepository.delete(team);
    }
}
