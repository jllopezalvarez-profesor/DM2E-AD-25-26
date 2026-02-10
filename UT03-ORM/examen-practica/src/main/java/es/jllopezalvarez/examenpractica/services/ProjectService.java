package es.jllopezalvarez.examenpractica.services;

import es.jllopezalvarez.examenpractica.entities.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAllByMinIncome(Double minIncome);
}
