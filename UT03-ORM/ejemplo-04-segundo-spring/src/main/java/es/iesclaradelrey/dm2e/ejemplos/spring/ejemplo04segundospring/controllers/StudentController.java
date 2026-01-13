package es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo04segundospring.controllers;

import es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo04segundospring.entities.Student;
import es.iesclaradelrey.dm2e.ejemplos.spring.ejemplo04segundospring.repositories.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping({"/students", "/students/"})
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

}
