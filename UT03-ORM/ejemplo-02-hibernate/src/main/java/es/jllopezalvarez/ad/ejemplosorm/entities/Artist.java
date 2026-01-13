package es.jllopezalvarez.ad.ejemplosorm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.util.Collection;

@Entity
@ToString(onlyExplicitlyIncluded = true)
@Getter
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private Long artistId;

    @Column(length = 120)
    @ToString.Include
    private String name;

    @OneToMany(mappedBy = "artist", fetch =  FetchType.EAGER)
    private Collection<Album> albums;
}
