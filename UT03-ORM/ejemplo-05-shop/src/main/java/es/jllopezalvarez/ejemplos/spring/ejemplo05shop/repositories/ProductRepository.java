package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.repositories;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Product;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.dto.SimpleProductInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByBrandBrandId(String brandId);

    @Query(value = "from Product p where p.brand.brandId = :brandId select p")
    List<Product> findAllByBrandBrandIdJpql(String brandId);

    @Query(value = "select * from product where brand_id = :brandId ", nativeQuery = true)
    List<Product> findAllByBrandBrandIdSql(@Param("brandId") String brandId);

    @Query(value = "select product_id, name from product", nativeQuery = true)
    List<SimpleProductInfoDto> findAllSimpleProductInfo();

    Page<Product> findAllByNameContaining(String productName, Pageable pagination);


    List<Product> findAllByBrandName(String brandName);

    List<Product> findAllByBrandBrandIdAndPriceLessThan(String brandId, BigDecimal maxPrice);
}
