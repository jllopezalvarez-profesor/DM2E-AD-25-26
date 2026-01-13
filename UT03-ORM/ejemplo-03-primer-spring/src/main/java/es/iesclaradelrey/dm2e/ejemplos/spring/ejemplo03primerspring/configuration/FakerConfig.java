package es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo03primerspring.configuration;

import net.datafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakerConfig {

    @Bean
    public Faker faker() {
        return new Faker();
    }
}
