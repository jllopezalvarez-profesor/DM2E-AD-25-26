package es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo03primerspring.commandlinerunners;

import es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo03primerspring.services.CounterService;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Ejemplo03CommandLineRunner implements CommandLineRunner {
    private final CounterService counterService;
    private final Faker faker;

    public Ejemplo03CommandLineRunner(CounterService counterService, Faker faker) {
        this.counterService = counterService;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ejemplo 03 CommandLineRunner");

        counterService.increment();

        System.out.printf("En el CLR 03 el contador vale: %d\n", counterService.getValue());

        String frase = faker.babylon5().quote();

        System.out.printf("En el CLR 03 la frase es: %s\n", frase);

    }
}
