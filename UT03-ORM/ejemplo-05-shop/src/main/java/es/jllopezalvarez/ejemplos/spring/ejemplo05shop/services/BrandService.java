package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.services;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.dto.BrandProductCountDto;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Brand;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BrandService {
    List<Brand> findAll();

    List<BrandProductCountDto> getAllProductCountDto();

    Optional<BigDecimal> getAveragePrice(String brandId);
}
