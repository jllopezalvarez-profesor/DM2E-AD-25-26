package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.repositories;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByNameIgnoreCase(String name);

    List<Category> findAllByNameContainingIgnoreCase(String name);

    List<Category> findAllByNameContainingAndCategoryIdGreaterThanOrderByNameAllIgnoreCase(String name, Long id);


}
