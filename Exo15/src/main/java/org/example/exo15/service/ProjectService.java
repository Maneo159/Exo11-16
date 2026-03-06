package org.example.exo15.service;

import org.example.exo15.entity.Project;
import org.example.exo15.entity.User;
import org.example.exo15.repository.ProjectRepository;
import org.example.exo15.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    public List<String> getProjectsByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            return List.of();
        }

        List<Project> projects = projectRepository.findByUser(user.get());
        return projects.stream()
                .map(Project::getName)
                .collect(Collectors.toList());
    }
}

