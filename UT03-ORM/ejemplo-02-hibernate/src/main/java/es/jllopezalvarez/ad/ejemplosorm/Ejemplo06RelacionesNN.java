package es.jllopezalvarez.ad.ejemplosorm;

import es.jllopezalvarez.ad.ejemplosorm.entities.Artist;
import es.jllopezalvarez.ad.ejemplosorm.entities.Playlist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Ejemplo06RelacionesNN {
    public static void main(String[] args) {
        try (
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("chinook");
                EntityManager em = emf.createEntityManager()) {

            // Busco una playlist
            Playlist playlist = em.find(Playlist.class, 16L);
            System.out.println(playlist);

            System.out.println("Pistas en la playlist:");
            playlist.getTracks().forEach(System.out::println);



        }
    }
}
