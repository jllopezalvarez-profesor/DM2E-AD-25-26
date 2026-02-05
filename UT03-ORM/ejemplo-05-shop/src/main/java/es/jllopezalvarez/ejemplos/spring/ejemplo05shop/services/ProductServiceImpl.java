package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.services;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Product;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.dto.SimpleProductInfoDto;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findByBrandId(String brandId) {
//        return productRepository.findAllByBrandBrandIdSql(brandId);
//        return productRepository.findAllByBrandBrandIdJpql(brandId);
        return productRepository.findAllByBrandBrandId(brandId);

    }

    @Override
    public List<Product> findByBrandName(String brandName) {
        return productRepository.findAllByBrandName(brandName);
    }

    @Override
    public List<Product> findByBrandIdAndMaxPrice(String brandId, Double maxPrice) {
        return productRepository.findAllByBrandBrandIdAndPriceLessThan(brandId, BigDecimal.valueOf(maxPrice));
    }

    @Override
    public List<SimpleProductInfoDto> findAllSimpleProductInfo(){
        return productRepository.findAllSimpleProductInfo();
    }

    @Override
    public Page<Product> findProducts(String productName, int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "name"));
        return productRepository.findAllByNameContaining(productName, pageRequest );
    }

}
