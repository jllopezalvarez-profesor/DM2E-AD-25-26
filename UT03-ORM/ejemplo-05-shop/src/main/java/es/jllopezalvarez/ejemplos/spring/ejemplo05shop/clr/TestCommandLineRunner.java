package es.jllopezalvarez.ejemplos.spring.ejemplo05shop.clr;

import es.jllopezalvarez.ejemplos.spring.ejemplo05shop.repositories.CategoryRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestCommandLineRunner implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public TestCommandLineRunner(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("En el CLR");
        System.out.println(categoryRepository.getClass().getCanonicalName());
        categoryRepository.findAll().forEach(System.out::println);

    }
}
