package es.jllopezalvarez.ad.ejemplosorm;

import es.jllopezalvarez.ad.ejemplosorm.entities.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Ejemplo01LeerUnObjeto {


    public static void main(String[] args) {
        try(
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("chinook");
                EntityManager em = emf.createEntityManager()){

            Genre genre = em.find(Genre.class, 1L);

            System.out.println(genre);

        }
    }
}
