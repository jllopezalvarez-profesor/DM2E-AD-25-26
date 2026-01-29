package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.services;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Product;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findByBrand(String brandId) {
        // TODO: cambiar esto por nuevo método.
        return productRepository.findAllByBrandBrandId(brandId);
    }
}
