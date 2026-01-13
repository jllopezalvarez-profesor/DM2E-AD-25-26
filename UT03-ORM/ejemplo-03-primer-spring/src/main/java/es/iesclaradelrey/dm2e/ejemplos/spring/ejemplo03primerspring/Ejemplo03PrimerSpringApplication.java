package es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo03primerspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ejemplo03PrimerSpringApplication {

    public static void main(String[] args) {
        System.out.println("Antes de arrancar la aplicación");
        SpringApplication.run(Ejemplo03PrimerSpringApplication.class, args);
        System.out.println("Después de arrancar la aplicación");

    }

}
