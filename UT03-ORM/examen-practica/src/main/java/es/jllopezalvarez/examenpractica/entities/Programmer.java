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
public class Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer programmerId;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String documentNumber;
    @Basic(optional = false)
    @Column(nullable = false, length = 50) // Si queremos que sea índice único: unique = true
    private String firstName;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String lastName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "project_programmer",
            joinColumns = @JoinColumn(name = "programmer_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Project> projects = new HashSet<>();
}
