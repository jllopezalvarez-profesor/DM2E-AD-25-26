package es.jllopezalvarez.examenpractica.repositories;

import es.jllopezalvarez.examenpractica.entities.Programmer;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammerRepository extends ListCrudRepository<Programmer, Integer> {
}
