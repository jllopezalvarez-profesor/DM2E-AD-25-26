package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    @Id
    @Column(length = 5)
    private String brandId;
    @Column(unique = true, length = 100)
    private String name;
    @Column(length = 2000)
    private String description;

    @OneToMany(mappedBy = "brand")
    private List<Product> products;
}
