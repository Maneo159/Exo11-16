package org.example.exo15.controller;

import org.example.exo15.dto.ProjectListResponse;
import org.example.exo15.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<?> getProjects(HttpServletRequest request) {
        String username = (String) request.getAttribute("username");

        if (username == null) {
            return ResponseEntity.status(401)
                    .body("{\"error\": \"Unauthorized\"}");
        }

        List<String> projects = projectService.getProjectsByUsername(username);
        return ResponseEntity.ok(new ProjectListResponse(projects));
    }
}

