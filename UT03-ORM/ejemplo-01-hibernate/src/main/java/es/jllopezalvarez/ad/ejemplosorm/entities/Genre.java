package es.jllopezalvarez.ad.ejemplosorm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Genre {
    @Id
    private Long genreId;
    private String name;

}
