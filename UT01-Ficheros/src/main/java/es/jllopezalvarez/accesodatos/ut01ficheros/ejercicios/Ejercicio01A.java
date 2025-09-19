package es.jllopezalvarez.accesodatos.ut01ficheros.ejercicios;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejercicio01A {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Preguntar al usuario
        System.out.println("Introduce la ruta del directorio:");
        String dirPath = scanner.nextLine();

        // crea el objeto file
        File dirFile = new File(dirPath);

        // ¿Existe?
        if (!dirFile.exists()) {
            System.out.println("El directorio no existe");
            return;
        }

        // ¿es un directorio?
        if (!dirFile.isDirectory()) {
            System.out.println("La ruta introducida no es un directorio");
            return;
        }

        File[] hijos = dirFile.listFiles();

        System.out.printf("Contenido del directorio %s:\n", dirPath);
        for (File hijo : hijos) { // da un warning porque el método listFiles puede devolver null
            System.out.printf("%s - %s - %s\n",
                    hijo.isDirectory()?"D":"F",
                    hijo.getName(),
                    hijo.isDirectory()?"N/A": hijo.length());

        }


    }
}
