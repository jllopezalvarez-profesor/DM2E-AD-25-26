package es.jllopezalvarez.examenpractica.repositories;

import es.jllopezalvarez.examenpractica.entities.Project;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends ListCrudRepository<Project, Integer> {
    List<Project> findAllByExpectedIncomeGreaterThanEqualOrderByProjectId(Double expectedIncomeIsGreaterThan);
}
