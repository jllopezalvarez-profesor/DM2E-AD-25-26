package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.repositories;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByBrandBrandId(String brandId);

}
