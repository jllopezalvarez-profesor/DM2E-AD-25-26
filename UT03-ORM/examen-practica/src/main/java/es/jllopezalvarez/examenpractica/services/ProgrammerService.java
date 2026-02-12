package es.jllopezalvarez.examenpractica.services;

import es.jllopezalvarez.examenpractica.dto.NewProgrammerDto;

public interface ProgrammerService {
    void createNew(NewProgrammerDto newProgrammerDto);

    boolean existsById(Integer programmerId);

    void deleteById(Integer programmerId);
}
