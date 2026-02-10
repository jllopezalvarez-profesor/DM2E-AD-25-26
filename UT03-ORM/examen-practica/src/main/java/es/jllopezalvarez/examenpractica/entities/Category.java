package es.jllopezalvarez.examenpractica.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false)
    private Double minIncome;
    @Basic(optional = false)
    @Column(nullable = false)
    private Double maxIncome;

    @OneToMany(mappedBy = "category")
    private Set<Programmer> programmers = new HashSet<>();
}
