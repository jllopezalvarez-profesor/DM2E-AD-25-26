package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.services;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Brand;

import java.util.Collection;
import java.util.List;

public interface BrandService {
    List<Brand> findAll();
}
