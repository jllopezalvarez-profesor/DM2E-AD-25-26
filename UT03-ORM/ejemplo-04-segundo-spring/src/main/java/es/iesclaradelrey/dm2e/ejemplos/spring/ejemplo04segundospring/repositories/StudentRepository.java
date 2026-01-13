package es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo04segundospring.repositories;

import es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo04segundospring.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends ListCrudRepository<Student, Long> {
}
