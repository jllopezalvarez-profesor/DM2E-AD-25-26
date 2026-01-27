package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.services;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();

    Category save(Category newCategory);

    Optional<Category> findById(Long categoryId);

    void deleteById(Long categoryId);

    boolean existsById(Long categoryId);
}
