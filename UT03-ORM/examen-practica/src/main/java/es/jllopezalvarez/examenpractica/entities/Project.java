package es.jllopezalvarez.examenpractica.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
    @Basic(optional = false)
    @Column(nullable = false, length = 200)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false, length = 200)
    private String clientName;
    @Basic(optional = false)
    @Column(nullable = false)
    private Double expectedIncome;
    private LocalDate startDate;


    @ManyToMany(mappedBy = "projects")
    private Set<Programmer> programmers = new HashSet<>();


}
