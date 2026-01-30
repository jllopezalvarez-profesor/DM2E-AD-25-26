package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.services;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Product;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.repositories.ProductRepository;
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
        return productRepository.findAllByBrandBrandId(brandId);
    }

    @Override
    public List<Product> findByBrandName(String brandId) {
        return productRepository.findAllByBrandName(brandId);
    }

    @Override
    public List<Product> findByBrandIdAndMaxPrice(String brandId, Double maxPrice) {
        return productRepository.findAllByBrandBrandIdAndPriceLessThan(brandId, BigDecimal.valueOf(maxPrice));
    }
}
