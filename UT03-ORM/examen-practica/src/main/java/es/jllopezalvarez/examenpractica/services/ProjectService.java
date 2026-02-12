package es.jllopezalvarez.examenpractica.services;

import es.jllopezalvarez.examenpractica.entities.Project;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProjectService {
    List<Project> findAllByMinIncome(Double minIncome);

    Page<Project> findAllByMinIncome(Double minIncome, int pageNumber, int pageSize);
}
