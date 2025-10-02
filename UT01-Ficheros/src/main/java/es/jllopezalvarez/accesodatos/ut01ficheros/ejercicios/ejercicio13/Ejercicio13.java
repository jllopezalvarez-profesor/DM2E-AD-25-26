package es.jllopezalvarez.accesodatos.ut01ficheros.ejercicios.ejercicio13;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import net.datafaker.Faker;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio13 {

    private static final int EDAD_MINIMA = 20;
    private static final int EDAD_MAXIMA = 50;
    private static final Path PATH_FICHERO = Paths.get("ejercicios/grupo-alumnos-01.xml");
    private static Faker faker = new Faker();

    public static void main(String[] args) throws JAXBException, IOException {

        GrupoAlumnos grupoAlumnos = new GrupoAlumnos("DM2E", "25-26", crearListaAlumnosAleatoria(21));

        JAXBContext context =  JAXBContext.newInstance(GrupoAlumnos.class);
        Marshaller  marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        try(FileOutputStream fos = new FileOutputStream(PATH_FICHERO.toFile())){
            marshaller.marshal(grupoAlumnos, fos);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try(FileInputStream fis = new FileInputStream(PATH_FICHERO.toFile())){
            GrupoAlumnos grupoAlumnosLeido = (GrupoAlumnos) unmarshaller.unmarshal(fis);
            grupoAlumnosLeido.getAlumnos().forEach(System.out::println);
        }










    }





    private static List<Alumno> crearListaAlumnosAleatoria(int cuantos){
        List<Alumno> alumnos = new ArrayList<>();
        while(cuantos-- > 0){
            alumnos.add(crearAlumnoAleatorio());
        }
        return alumnos;
    }


    private static Alumno crearAlumnoAleatorio() {
        return new Alumno(faker.idNumber().valid(),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.timeAndDate().birthday(EDAD_MINIMA, EDAD_MAXIMA),
                faker.credentials().password());
    }
}
