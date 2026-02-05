package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.controllers;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.dto.ProductDto;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Product;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.dto.SimpleProductInfoDto;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/brand/{brandId:B\\d}")
    public ResponseEntity<List<ProductDto>> findAllByBrandId(@PathVariable String brandId) {
        List<Product> products = productService.findByBrandId(brandId);
        List<ProductDto> productDtos = products.stream().map(this::map).toList();
        return ResponseEntity.ok(productDtos);
    }

    @GetMapping("/brand/{brandName:[a-zA-Z]+}")
    public ResponseEntity<List<ProductDto>> findAllByBrandName(@PathVariable String brandName) {
        List<Product> products = productService.findByBrandName(brandName);
        List<ProductDto> productDtos = products.stream().map(this::map).toList();
        return ResponseEntity.ok(productDtos);
    }


    @GetMapping("/brand-and-max-price/{brandId:B\\d}")
    public ResponseEntity<List<ProductDto>> findAllByBrandIdAndMaxPrice(
            @PathVariable String brandId,
            @RequestParam Double maxPrice) {
        List<Product> products = productService.findByBrandIdAndMaxPrice(brandId, maxPrice);
        List<ProductDto> productDtos = products.stream().map(this::map).toList();
        return ResponseEntity.ok(productDtos);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<ProductDto>> findAllByCategoryIds(
            @RequestParam List<Long> categoryIds) {
        System.out.println(categoryIds);
//        List<Product> products = productService.findByBrandIdAndMaxPrice(categoryIds);
//        List<ProductDto> productDtos = products.stream().map(this::map).toList();
//        return ResponseEntity.ok(productDtos);
        return ResponseEntity.ok(List.of());
    }

    @GetMapping("/getAllInfo")
    ResponseEntity<List<SimpleProductInfoDto>> findAllSimpleProductInfo(){
        return ResponseEntity.ok(productService.findAllSimpleProductInfo());
    }


    @GetMapping("/search")
//    public ResponseEntity<Page<Product>> findProducts(
            public ResponseEntity<Page<ProductDto>> findProducts(
            @RequestParam(defaultValue = "") String productName,
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "5") Integer pageSize){

        Page<Product> productsPage = productService.findProducts(productName, pageNumber, pageSize);


        var mappedProductsPage = productsPage.map(this::map);

        return ResponseEntity.ok(mappedProductsPage);




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
