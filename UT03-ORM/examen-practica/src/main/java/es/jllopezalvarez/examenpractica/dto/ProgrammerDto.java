package es.jllopezalvarez.examenpractica.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgrammerDto {
    private Integer programmerId;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private String categoryName;
    private CategoryDto category;
}
