package es.jllopezalvarez.ad.ejemplosorm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "track", indexes = {
        @Index(name = "track_album_id_idx", columnList = "album_id"),
        @Index(name = "track_media_type_id_idx", columnList = "media_type_id"),
        @Index(name = "track_genre_id_idx", columnList = "genre_id")
})
@ToString(onlyExplicitlyIncluded = true)
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_id", nullable = false)
    private Integer trackId;

    @Column(name = "name", nullable = false, length = 200)
    @ToString.Include
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "media_type_id", nullable = false)
    private MediaType mediaType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Column(name = "composer", length = 220)
    private String composer;

    @Column(name = "milliseconds", nullable = false)
    private Integer milliseconds;

    @Column(name = "bytes")
    private Integer bytes;

    @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @ManyToMany(mappedBy = "tracks")
    private Set<Playlist> playlists = new LinkedHashSet<>();

}