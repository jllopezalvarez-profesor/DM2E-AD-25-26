package es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo03primerspring.commandlinerunners;

import es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo03primerspring.services.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Ejemplo01CommandLineRunner implements CommandLineRunner {
    private final CounterService counterService;

    public Ejemplo01CommandLineRunner(@Autowired CounterService counterService) {
        this.counterService = counterService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ejemplo 01 CommandLineRunner");
        counterService.increment();
        System.out.printf("En el CLR 01 el contador vale: %d\n", counterService.getValue());
    }
}
