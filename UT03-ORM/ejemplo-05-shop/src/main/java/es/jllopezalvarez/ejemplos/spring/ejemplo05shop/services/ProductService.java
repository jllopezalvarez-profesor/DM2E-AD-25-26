package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.services;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Product;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.dto.SimpleProductInfoDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    List<Product> findByBrandId(String brandId);

    List<Product> findByBrandName(String brandId);

    List<Product> findByBrandIdAndMaxPrice(String brandId, Double maxPrice);

    List<SimpleProductInfoDto> findAllSimpleProductInfo();

    Page<Product> findProducts(String productName, int pageNumber, int pageSize);
}
