package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.repositories;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.dto.BrandProductCountDto;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Brand;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
    @Query(value="from Brand b select new es.jllopezalvarez.ejemplos.spring.ejemplo05shop.dto.BrandProductCountDto(b.name, count(b.products))")
    List<BrandProductCountDto> getAllProductCountDto();

    @Query(value = "from Product p where p.brand.brandId = :brandId select avg (p.price)")
    Optional<BigDecimal> getAveragePrice(@Param("brandId") String brandId);
}
