package es.jllopezalvarez.accesodatos.ut01ficheros.ejercicios;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio05 {

    private static Scanner scanner = new Scanner(System.in);
    private static final Set<Character> VOCALES = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public static void main(String[] args) {

        System.out.println("Dime la ruta del fichero que hay que leer:");
        String ruta = scanner.nextLine();

        if (!Files.exists(Paths.get(ruta))) { // Path.of también sirve
            System.err.println("No existe un fichero en esa ubicación.");
            System.exit(1);
        }

        if (Files.isDirectory(Paths.get(ruta))) { // Path.of también sirve
            System.err.println("La ruta introducida es un directorio.");
            System.exit(1);
        }

        String rutaSalida = String.format("%s.sinvocales", ruta);

        try(FileReader reader = new FileReader(ruta); FileWriter writer = new FileWriter(rutaSalida)) {
            int intChar;
            while ((intChar = reader.read()) != -1) {
                char c = (char) intChar;
                if (!VOCALES.contains(c)) {
                    writer.write(c);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("No esxiste o no se puede acceder al fichero.", e);
        } catch (IOException e) {
            throw new RuntimeException("Error al acceder al fichero", e);
        }


    }

}
