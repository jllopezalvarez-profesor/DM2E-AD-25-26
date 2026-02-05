package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.controllers;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.dto.BrandDto;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.dto.BrandProductCountDto;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities.Brand;
import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.services.BrandServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brands")
public class BrandController {

    private final BrandServiceImpl brandService;

    public BrandController(BrandServiceImpl brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<BrandDto> findAll(){
        return brandService.findAll().stream().map(this::map).toList();
    }

    @GetMapping("/product-count")
    ResponseEntity<List<BrandProductCountDto>> getProductsCount(){

//        BrandProductCountDto c = new BrandProductCountDto("fdsfd", 3);
//        int cuenta = c.productCount();
        return ResponseEntity.ok(brandService.getAllProductCountDto());



    }


    @GetMapping("/{brandId}/avg-price")
    public ResponseEntity<BigDecimal> getAveragePrice(@PathVariable String brandId){
        Optional<BigDecimal> average = brandService.getAveragePrice(brandId);
        if (average.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(average.orElseThrow());
    }


    private BrandDto map(Brand brand) {
        return BrandDto.builder()
                .brandId(brand.getBrandId())
                .name(brand.getName())
                .description(brand.getDescription())
                .build();
    }


}
