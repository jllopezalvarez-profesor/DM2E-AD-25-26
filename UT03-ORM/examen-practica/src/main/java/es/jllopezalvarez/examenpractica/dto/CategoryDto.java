package es.jllopezalvarez.examenpractica.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
    private Integer categoryId;
    private String name;
    private Double minIncome;
    private Double maxIncome;
}

