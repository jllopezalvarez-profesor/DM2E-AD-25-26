package es.jllopezalvarez.accesodatos.ut01ficheros.ejercicios;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio01B {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        * Crea un programa en Java que pregunte al usuario una ruta de un directorio del sistema de archivos y:
    • Verifique que el directorio existe. Si no existe muestra un mensaje indicándolo y el programa termina.
    • Verifique que la ruta que ha indicado el usuario es realmente un directorio. Si en lugar de directorio es un fichero, se muestra un mensaje indicándolo y el programa termina.
    • Realice un listado de todos los directorios y ficheros dentro de ese directorio, indicando:
        ◦ Si es directorio o fichero.
        ◦ Si es fichero, que muestre también su tamaño.
        *
        * */

        // Preguntar al usuario
        System.out.println("Introduce la ruta del directorio:");
        String dirPath = scanner.nextLine();

        // ¿Existe?


        if (!Files.exists(Paths.get(dirPath))) { //Path.of(dirPath)
            System.out.println("El directorio no existe");
            return;
        }

        // ¿es un directorio?
        if (!Files.isDirectory(Path.of(dirPath))) {
            System.out.println("La ruta introducida no es un directorio");
            return;
        }

        try  (Stream<Path> hijos = Files.list(Paths.get(dirPath))) {
//            hijos.forEach(System.out::println);
            hijos.forEach(path -> {
                try {
                    System.out.printf("%s - %s - %s\n",
                        Files.isDirectory(path) ? "D" : "F",
                        path.getFileName(),
                        Files.isDirectory(path) ? "N/A" : Files.size(path));
                } catch (IOException e) {
                    throw new RuntimeException("Error al procesar la expresión.", e);
                }
            });


        } catch (IOException e) {
            throw new RuntimeException("Error al acceder al listado del directorio.", e);
        }


//        System.out.printf("Contenido del directorio %s:\n", dirPath);
//        for (File hijo : hijos) { // da un warning porque el método listFiles puede devolver null
//            System.out.printf("%s - %s - %s\n",
//                    hijo.isDirectory() ? "D" : "F",
//                    hijo.getName(),
//                    hijo.isDirectory() ? "N/A" : hijo.length());
//
//        }


    }
}
