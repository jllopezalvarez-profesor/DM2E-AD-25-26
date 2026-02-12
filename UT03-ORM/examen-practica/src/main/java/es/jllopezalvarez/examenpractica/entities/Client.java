package es.jllopezalvarez.examenpractica.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;
    @Column(nullable = false, length = 10, unique = true)
    private String cif;
    @Column(nullable = false, length = 200)
    private String name;

    @OneToMany(mappedBy = "client")
    private Set<Project> projects;
}
