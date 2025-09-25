package es.jllopezalvarez.accesodatos.ut01ficheros.ejercicios.ejercicio12;

import java.time.LocalDate;

public class AlumnoSinLombok {
    private final String dni;
    private final String nombre;
    private final String apellido;
    private final LocalDate fechaNacimiento;

    public AlumnoSinLombok(String dni, String nombre, String apellido, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getEdad(){
        LocalDate fechaActual = LocalDate.now();
        return this.fechaNacimiento.until(fechaActual).getYears();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Alumno{");
        sb.append("dni='").append(dni).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append('}');
        return sb.toString();
    }
}
