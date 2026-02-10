package es.jllopezalvarez.examenpractica.controllers;

import es.jllopezalvarez.examenpractica.dto.ProjectDto;
import es.jllopezalvarez.examenpractica.services.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/min-expected-income/{minIncome}")
    ResponseEntity<List<ProjectDto>> findAllByMinIncome(@PathVariable Double minIncome) {

        return ResponseEntity.notFound().build();
    }
}