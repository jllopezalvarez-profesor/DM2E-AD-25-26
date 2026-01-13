package es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo04segundospring.services;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public void sayHelloWorld() {
        System.out.println("Hello World");
    }
}
