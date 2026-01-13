package es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo03primerspring.commandlinerunners;

import es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo03primerspring.services.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Ejemplo02CommandLineRunner implements CommandLineRunner {

    @Autowired
    private CounterService counterService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ejemplo 02 CommandLineRunner");
        counterService.increment();
        System.out.printf("En el CLR 02 el contador vale: %d\n", counterService.getValue());

    }
}
