package es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo04segundospring.commandlinerunners;

import es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo04segundospring.entities.Student;
import es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo04segundospring.repositories.StudentRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class RepositoryTestCommandLineRunner implements CommandLineRunner {
    private final StudentRepository studentRepository;

    public RepositoryTestCommandLineRunner(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("En RepositoryTestCommandLineRunner");

        Faker faker = new Faker(Locale.forLanguageTag("es-ES"));

        for (int i = 0; i < 10; i++) {
            Student student = Student.builder()
                    .dni(faker.idNumber().valid())
                    .firstName(faker.name().firstName())
                    .lastName(faker.name().lastName())
                    .build()                    ;
            studentRepository.save(student);

        }





        studentRepository.findAll().forEach(System.out::println);

    }
}
