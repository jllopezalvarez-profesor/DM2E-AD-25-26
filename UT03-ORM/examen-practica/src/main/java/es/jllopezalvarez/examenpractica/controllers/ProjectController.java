package es.jllopezalvarez.examenpractica.controllers;

import es.jllopezalvarez.examenpractica.dto.ProjectDto;
import es.jllopezalvarez.examenpractica.entities.Project;
import es.jllopezalvarez.examenpractica.services.ProjectService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<Project> projects = projectService.findAllByMinIncome(minIncome);

        ModelMapper mapper = new ModelMapper();

//        Para mapear un solo proyecto:
//        Project p = new Project();
//        ProjectDto pDto = mapper.map(p, ProjectDto.class);

//        PropertyMap<Project, ProjectDto> map = new PropertyMap<Project, ProjectDto>() {
//            @Override
//            protected void configure() {
//                map().setProjectId(null);
//
//            }
//        };


        List<ProjectDto> projectsDtos = projects.stream()
                .map(p -> mapper.map(p, ProjectDto.class))
                .toList();


        return ResponseEntity.ok(projectsDtos);
    }


    @GetMapping("/min-expected-income-paged/{minIncome}")
    ResponseEntity<Page<ProjectDto>> findAllByMinIncomePaged(@PathVariable Double minIncome,
                                                             @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
                                                             @RequestParam(name = "pageSize", defaultValue = "2") int pageSize) {
        Page<Project> projects = projectService.findAllByMinIncome(minIncome, pageNumber, pageSize);

        ModelMapper mapper = new ModelMapper();

//        Para mapear un solo proyecto:
//        Project p = new Project();
//        ProjectDto pDto = mapper.map(p, ProjectDto.class);

//        PropertyMap<Project, ProjectDto> map = new PropertyMap<Project, ProjectDto>() {
//            @Override
//            protected void configure() {
//                map().setProjectId(null);
//
//            }
//        };


//
//        List<ProjectDto> projectsDtos = projects.stream()
//                .map(p -> mapper.map(p, ProjectDto.class))
//                .toList();


        return ResponseEntity.ok(projects.map(p -> mapper.map(p, ProjectDto.class)));
    }
}