package es.jllopezalvarez.ad.ejemplosorm;

import es.jllopezalvarez.ad.ejemplosorm.entities.Playlist;
import es.jllopezalvarez.ad.ejemplosorm.entities.Track;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Ejemplo07RelacionesLazy {
    public static void main(String[] args) {
        try (
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("chinook");
                EntityManager em = emf.createEntityManager()) {

            // Busco una pista
            Track track = em.find(Track.class, 16L);
            System.out.println(track);

            System.out.println("Artista:");
            System.out.println(track.getAlbum().getArtist());



        }
    }
}
