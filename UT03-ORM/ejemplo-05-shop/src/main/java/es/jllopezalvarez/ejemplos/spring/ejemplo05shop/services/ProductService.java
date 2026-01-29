package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.services;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> findByBrand(String brandId);
}
