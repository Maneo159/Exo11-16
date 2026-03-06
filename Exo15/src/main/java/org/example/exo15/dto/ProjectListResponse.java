package org.example.exo15.dto;

import java.util.List;

public class ProjectListResponse {
    private List<String> projects;

    public ProjectListResponse(List<String> projects) {
        this.projects = projects;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }
}

