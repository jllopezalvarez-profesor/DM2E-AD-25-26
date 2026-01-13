package es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo04segundospring.commandlinerunners;

import es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo04segundospring.services.HelloWorldService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestCommandLineRunner implements CommandLineRunner {

    private final HelloWorldService helloWorldService;

    public TestCommandLineRunner(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("En TestCommandLineRunner.run");

        helloWorldService.sayHelloWorld();
    }
}
