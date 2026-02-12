package es.jllopezalvarez.examenpractica.services;


import es.jllopezalvarez.examenpractica.entities.Project;
import es.jllopezalvarez.examenpractica.repositories.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        //return projectRepository.findAllByExpectedIncomeGreaterThanEqualOrderByProjectId(minIncome);
        // return projectRepository.findProjectParte2Jpql(minIncome);
        return projectRepository.findProjectParte2Sql(minIncome);
    }

    @Override
    public Page<Project> findAllByMinIncome(Double minIncome, int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return projectRepository.findAllByExpectedIncomeGreaterThanEqualOrderByProjectId(minIncome, pageRequest);
    }
}
