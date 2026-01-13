package es.jllopezalvarez.ad.ejemplosorm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "media_type")
public class MediaType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "media_type_id", nullable = false)
    private Integer mediaTypeId;

    @Column(name = "name", length = 120)
    private String name;

}