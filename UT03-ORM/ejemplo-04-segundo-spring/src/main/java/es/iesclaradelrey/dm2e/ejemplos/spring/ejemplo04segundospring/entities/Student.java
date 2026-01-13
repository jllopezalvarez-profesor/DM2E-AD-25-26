package es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo04segundospring.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, nullable = false, unique = true)
    private String dni;

    @Column(length = 100, nullable = false)
    private String firstName;
    @Column(length = 120, nullable = false)
    private String lastName;

}
