package es.jllopezalvarez.examenpractica.repositories;

import es.jllopezalvarez.examenpractica.entities.Project;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends ListCrudRepository<Project, Integer> {
}
