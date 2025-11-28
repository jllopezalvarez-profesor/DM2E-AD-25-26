package es.jllopezalvarez.ad.ejemplosorm.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "genre_id")
    private Long genreId;
    @Column(name = "name")
    private String genreName;
}
