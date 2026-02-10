package es.jllopezalvarez.examenpractica.services;


import es.jllopezalvarez.examenpractica.entities.Project;
import es.jllopezalvarez.examenpractica.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAllByMinIncome(Double minIncome) {
        return projectRepository.findAllByExpectedIncomeGreaterThanEqualOrderByProjectId(minIncome);
    }
}
