package es.jllopezalvarez.accesodatos.ut01ficheros.ejercicios.ejercicio13;

import com.sun.xml.txw2.annotation.XmlElement;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "alumnooooo")
//@XmlElement
public class Alumno implements Serializable {
    @EqualsAndHashCode.Include
    private final String dni;
    private final String nombre;
    private final String apellido;
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    private final LocalDate fechaNacimiento;
    @XmlTransient
    private final String password;

    public int getEdad(){
        LocalDate fechaActual = LocalDate.now();
        return this.fechaNacimiento.until(fechaActual).getYears();
    }
}
