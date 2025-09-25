package es.jllopezalvarez.accesodatos.ut01ficheros.ejercicios.ejercicio12;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Alumno implements Serializable {
    @EqualsAndHashCode.Include
    private final String dni;
    private final String nombre;
    private final String apellido;
    private LocalDate fechaNacimiento;

    public int getEdad(){
        LocalDate fechaActual = LocalDate.now();
        return this.fechaNacimiento.until(fechaActual).getYears();
    }
}
