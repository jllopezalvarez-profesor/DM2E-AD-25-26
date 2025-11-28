package es.jllopezalvarez.ad.ejemplosorm;

import es.jllopezalvarez.ad.ejemplosorm.entities.Album;
import es.jllopezalvarez.ad.ejemplosorm.entities.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Ejemplo05Relaciones {
    public static void main(String[] args) {
        try (
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("chinook");
                EntityManager em = emf.createEntityManager()) {

            Album album = em.find(Album.class, 1L);

            System.out.println(album);

            Artist  artist = em.find(Artist.class, 1L);

            System.out.println(artist);



        }
    }
}
