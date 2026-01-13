package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.services;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
}
