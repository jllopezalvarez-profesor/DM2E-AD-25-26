package es.jllopezalvarez.accesodatos.ut01ficheros.ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejercicio04 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Dime la ruta del fichero que hay que crear:");
        String ruta = scanner.nextLine();

        if (Files.exists(Paths.get(ruta))) { // Path.of también sirve
            System.err.println("Ya existe un fichero o directorio en esa ubicación.");
            System.exit(1);
        }

        ensureDirectoryExists(ruta);

        System.out.println("Introduce líneas de texto para incluir en el fichero.");
        System.out.println("Escribe una linea 'FIN' para terminar");

        try(PrintWriter pw = new PrintWriter(new FileOutputStream(ruta))) {
            String linea;
            do {
                linea = scanner.nextLine();
                pw.println(linea);
            } while (!linea.equals("FIN"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error al crear el fichero", e);
        }

    }

    private static void ensureDirectoryExists(String ruta) {
        File file = new File(ruta);
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }
    }
}
