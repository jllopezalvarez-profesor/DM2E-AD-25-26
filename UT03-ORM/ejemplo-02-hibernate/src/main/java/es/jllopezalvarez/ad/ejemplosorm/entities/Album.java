package es.jllopezalvarez.ad.ejemplosorm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity
@ToString(onlyExplicitlyIncluded = true)
@Getter
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private Long albumId;
    @Column(length = 160)
    @ToString.Include
    private String title;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
}
