package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ProductDto {
    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
}
