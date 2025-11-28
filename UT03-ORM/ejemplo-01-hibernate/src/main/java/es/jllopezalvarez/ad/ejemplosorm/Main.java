package es.jllopezalvarez.ad.ejemplosorm;

import es.jllopezalvarez.ad.ejemplosorm.entities.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory("chinook");
            EntityManager em = factory.createEntityManager())
        {
            Genre g = em.find(Genre.class, 1L);
            System.out.println(g);


        }

    }
}