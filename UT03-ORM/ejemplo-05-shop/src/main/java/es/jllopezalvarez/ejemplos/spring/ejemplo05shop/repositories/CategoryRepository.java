package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.repositories;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
