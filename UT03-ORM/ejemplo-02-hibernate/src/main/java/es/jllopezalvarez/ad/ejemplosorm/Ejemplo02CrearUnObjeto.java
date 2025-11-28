package es.jllopezalvarez.ad.ejemplosorm;

import es.jllopezalvarez.ad.ejemplosorm.entities.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Ejemplo02CrearUnObjeto {


    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("chinook");
             EntityManager em = emf.createEntityManager()) {

            // Abro transacción porque sin ella no se guardan datos
            em.getTransaction().begin();

            // Crear una nuevo género
            // Como la BD genera las claves, solo doy nombre al nuevo género
            Genre newGenre = Genre.builder().genreName("Nuevo género").build();

            System.out.println("Antes de guardar");
            System.out.println(newGenre);

            // Guardarlo en la BD
            em.persist(newGenre);

            newGenre.setGenreName("Este nombre es nuevo, pero cambiado");
            // Modificar el nombre
            em.merge(newGenre);

            System.out.println("Después de guardar");
            System.out.println(newGenre);


            em.getTransaction().commit();


        }
    }
}
