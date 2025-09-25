package es.jllopezalvarez.accesodatos.ut01ficheros.ejercicios.ejercicio12;

import net.datafaker.Faker;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio12 {

    private static final int EDAD_MINIMA = 20;
    private static final int EDAD_MAXIMA = 50;
    private static final Path PATH_FICHERO = Paths.get("ejercicios/serializado.dat");
    private static Faker faker = new Faker();

    public static void main(String[] args) {
        Alumno alumno = crearAlumnoAleatorio();
        guardarAlumno(alumno, PATH_FICHERO);
        mostrarAlumnosFichero(PATH_FICHERO);
    }

    private static void guardarAlumno(Alumno alumno, Path path) {

        List<Alumno> alumnosAntiguos = new ArrayList<>();
        if (Files.exists(path)) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
                while (true) {
                    alumnosAntiguos.add((Alumno) ois.readObject());
                }
            }catch (EOFException e){
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            for (Alumno a : alumnosAntiguos) {
                oos.writeObject(a);
            }
            oos.writeObject(alumno);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error de permisos al guardar el alumno.", e);
        } catch (IOException e) {
            throw new RuntimeException("Error de E/S al guardar el alumno", e);
        }
    }


    private static void mostrarAlumnosFichero(Path path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            while (true) {

                Alumno alumno = (Alumno) ois.readObject();
                System.out.println(alumno);
            }
        } catch (EOFException e) {

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error de acceso a lfichero al leer", e);
        } catch (IOException e) {
            throw new RuntimeException("", e);
        }
    }


    private static Alumno crearAlumnoAleatorio() {

        return new Alumno(faker.idNumber().valid(),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.timeAndDate().birthday(EDAD_MINIMA, EDAD_MAXIMA));
    }
}
