package es.jllopezalvarez.examenpractica.services;

import es.jllopezalvarez.examenpractica.dto.NewProgrammerDto;
import es.jllopezalvarez.examenpractica.entities.Category;
import es.jllopezalvarez.examenpractica.entities.Programmer;
import es.jllopezalvarez.examenpractica.repositories.CategoryRepository;
import es.jllopezalvarez.examenpractica.repositories.ProgrammerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {
    private final ProgrammerRepository programmerRepository;
    private final CategoryRepository categoryRepository;

    public ProgrammerServiceImpl(ProgrammerRepository programmerRepository, CategoryRepository categoryRepository) {
        this.programmerRepository = programmerRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createNew(NewProgrammerDto newProgrammerDto) {
        // 1- Obtener la categoría. Y si no existe, excepción.
//        Optional<Category> categoryOptional = categoryRepository.findById(newProgrammerDto.getCategoryId());
//        if(categoryOptional.isEmpty()){
//            throw  new EntityNotFoundException(String.format("No existe la categoría con código %d", newProgrammerDto.getCategoryId()));
//        }

        Category category = categoryRepository
                .findById(newProgrammerDto.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException(String.format("No existe la categoría con código %d", newProgrammerDto.getCategoryId())));

        // 2- Crear nuevo objeto Programmer
        Programmer programmer = Programmer.builder()
                .documentNumber(newProgrammerDto.getDocumentNumber())
                .firstName(newProgrammerDto.getFirstName())
                .lastName(newProgrammerDto.getLastName())
                .category(category)
                .build();

        // 3- Guardar el programador

        programmerRepository.save(programmer);

    }

    @Override
    public boolean existsById(Integer programmerId) {
        return programmerRepository.existsById(programmerId);
    }

    @Override
    public void deleteById(Integer programmerId) {
        programmerRepository.deleteById(programmerId);

    }
}
