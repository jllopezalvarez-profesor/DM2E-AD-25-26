package es.jllopezalvarez.accesodatos.ut01ficheros.ejemplos.repaso;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class Ejemplo10CadenasFormato {
    public static void main(String[] args) {

        // Básico, sin parámetros
        System.out.printf("Esto es la primera línea%n");
        System.out.printf("Esto es la segunda línea\n");

        // Insertar una cadena
        String nombre = "José Luis";
        System.out.println("Hola " + nombre + ", buenos días." );
        System.out.printf("Hola %s, buenos días.\n", nombre);

        // Insertar otro tipo de dato como cadena
        System.out.printf("Son las %s.\n", LocalTime.now());

        // Insertar números
        Random rnd = new Random();
        System.out.printf("El número entero generado es: %d\n",  rnd.nextInt());
        System.out.printf("El numero real generado es: %f\n", rnd.nextDouble());

        // Acortar el número de decimales
        Double numeroConDecimales = rnd.nextDouble();
        System.out.printf("El numero real generado (con todos los decimales) es: %f\n", numeroConDecimales);
        System.out.printf("El numero real generado (con dos decimales) es: %.2f\n", numeroConDecimales);

        // Varias cosas en uan línea y anchos y alineación
        int numFactura = 235432;
        String nombreCliente = "José Luis López Álvarez";
        nombreCliente = "José";
        double importe = 3432.3432;

        System.out.printf("%20s - %-10.20s - %f\n", numFactura, nombreCliente, importe);

        // Para hacerlo en memoria:
        String cadenaConFormato = String.format("%s - %d","Hola", 1234);
        System.out.println(cadenaConFormato);



    }
}
