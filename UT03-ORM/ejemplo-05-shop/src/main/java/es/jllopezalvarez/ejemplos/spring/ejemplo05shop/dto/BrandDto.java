package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BrandDto {
    private String brandId;
    private String name;
    private String description;
}
