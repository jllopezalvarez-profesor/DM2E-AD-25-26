package es.jllopezalvarez.accesodatos.ut01ficheros.ejercicios.ejercicio13;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
//@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@Getter
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class GrupoAlumnos {
//    @XmlAttribute
    private final String nombreGrupo;
//    @XmlElement
    private final String anioEscolar;

    @XmlElementWrapper(name = "alumnos")
    @XmlElement(name = "alumno")
    private final List<Alumno> alumnos;

    public GrupoAlumnos() {
        this.nombreGrupo = null;
        this.anioEscolar = null;
        this.alumnos = new ArrayList<>();
    }
}
