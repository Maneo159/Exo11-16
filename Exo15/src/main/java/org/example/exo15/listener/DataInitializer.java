package org.example.exo15.listener;

import org.example.exo15.entity.Project;
import org.example.exo15.entity.User;
import org.example.exo15.repository.ProjectRepository;
import org.example.exo15.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeData() {
        // Create users
        User user1 = new User("alice", "password123");
        User user2 = new User("bob", "password456");

        userRepository.save(user1);
        userRepository.save(user2);

        // Create projects for alice
        Project project1 = new Project("Projet A", "Premier projet d'Alice", user1);
        Project project2 = new Project("Projet B", "Deuxième projet d'Alice", user1);

        projectRepository.save(project1);
        projectRepository.save(project2);

        // Create projects for bob
        Project project3 = new Project("Projet C", "Projet de Bob", user2);
        Project project4 = new Project("Projet D", "Autre projet de Bob", user2);

        projectRepository.save(project3);
        projectRepository.save(project4);
    }
}

