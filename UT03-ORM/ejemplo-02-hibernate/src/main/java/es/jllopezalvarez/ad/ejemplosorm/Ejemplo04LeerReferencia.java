package es.jllopezalvarez.ad.ejemplosorm;

import es.jllopezalvarez.ad.ejemplosorm.entities.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Ejemplo04LeerReferencia {


    public static void main(String[] args) {
        try(
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("chinook");
                EntityManager em = emf.createEntityManager()){

            System.out.println("Iniciando leer referencia");
            Genre genre = em.getReference(Genre.class, 100L);
            System.out.println("La referencia se ha encontrado");
            System.out.println("Género encontrado:");
            System.out.println(genre);
            System.out.println("Después de mostrar la referencia");

        }
    }
}
