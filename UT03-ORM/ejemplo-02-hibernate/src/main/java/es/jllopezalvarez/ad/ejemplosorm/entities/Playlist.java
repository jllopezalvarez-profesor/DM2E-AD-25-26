package es.jllopezalvarez.ad.ejemplosorm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "playlist")
@ToString(onlyExplicitlyIncluded = true)
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_id", nullable = false)
    private Integer playlistId;

    @Column(name = "name", length = 120)
    @ToString.Include
    private String name;

    @ManyToMany
    @JoinTable(name = "playlist_track",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id"))

    private Set<Track> tracks = new LinkedHashSet<>();

}