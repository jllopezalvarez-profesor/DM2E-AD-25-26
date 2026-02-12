package es.jllopezalvarez.examenpractica.controllers;

import es.jllopezalvarez.examenpractica.dto.NewProgrammerDto;
import es.jllopezalvarez.examenpractica.services.ProgrammerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/programmers")
public class ProgrammerController {
    private final ProgrammerService programmerService;

    public ProgrammerController(ProgrammerService programmerService) {
        this.programmerService = programmerService;
    }

//    @PostMapping("/api/programmers") // Si no se usa RequestMapping en el controlador
    @PostMapping({"", "/"})
    public ResponseEntity<String> createProgrammer(@RequestBody NewProgrammerDto newProgrammerDto){
        try {
            programmerService.createNew(newProgrammerDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Programador creado");
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }

    }

    @DeleteMapping("/{programmerId}")
    public ResponseEntity<String> deleteProgrammer(@PathVariable Integer programmerId){
        if (!programmerService.existsById(programmerId)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    String.format("No se encuentra el programador con id %d", programmerId));
        }

        programmerService.deleteById(programmerId);

        return ResponseEntity.status(HttpStatus.CREATED).body("Programador eliminado");


    }

}
