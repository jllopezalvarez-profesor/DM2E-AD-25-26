package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.controllers;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.dto.ProductDto;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Product;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/brand/{brandId}")
    public ResponseEntity<List<ProductDto>> findAllByBrand(@PathVariable String brandId) {
        List<Product> products = productService.findByBrand(brandId);
        List<ProductDto> productDtos = products.stream().map(this::map).toList();
        return ResponseEntity.ok(productDtos);
    }

    private ProductDto map(Product product) {
        return ProductDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
