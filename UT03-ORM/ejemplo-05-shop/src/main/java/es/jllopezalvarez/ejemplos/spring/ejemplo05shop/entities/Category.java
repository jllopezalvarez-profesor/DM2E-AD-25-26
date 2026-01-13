package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long categoryId;
    @Basic(optional = false)
    @Column(length = 100, unique = true)
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "categories")
    private List<Product> products;
}
