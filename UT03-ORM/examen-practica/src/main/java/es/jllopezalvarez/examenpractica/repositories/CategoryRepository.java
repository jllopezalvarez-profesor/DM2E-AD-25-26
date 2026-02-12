package es.jllopezalvarez.examenpractica.repositories;

import es.jllopezalvarez.examenpractica.entities.Category;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ListCrudRepository<Category, Integer> {
}
