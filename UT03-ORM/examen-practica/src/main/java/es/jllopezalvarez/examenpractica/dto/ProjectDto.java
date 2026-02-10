package es.jllopezalvarez.examenpractica.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDto {
    private Integer projectId;
    private String name;
    private String clientName;
    private Double expectedIncome;
    private LocalDate startDate;
    private Set<ProgrammerDto> programmers = new HashSet<>();
}
