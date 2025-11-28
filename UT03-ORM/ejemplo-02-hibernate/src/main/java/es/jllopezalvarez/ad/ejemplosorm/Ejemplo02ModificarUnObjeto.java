package es.jllopezalvarez.ad.ejemplosorm;

import es.jllopezalvarez.ad.ejemplosorm.entities.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Ejemplo02ModificarUnObjeto {


    public static void main(String[] args) {
        try(
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("chinook");
                EntityManager em = emf.createEntityManager()){

            em.getTransaction().begin();

            Genre genre = em.find(Genre.class, 1L);
            System.out.println("Antes de modificar");
            System.out.println(genre);

            genre.setGenreName(genre.getGenreName() + "-|");
           em.merge(genre);
            //em.persist(genre);

            em.getTransaction().commit();

            genre = em.find(Genre.class, 1L);
            System.out.println("Después de modificar");
            System.out.println(genre);

            em.getTransaction().begin();
            System.out.println("Antes de lanzar la segunda modificación");
            String nombreAntiguo = genre.getGenreName();
            genre.setGenreName("Este nombre es nuevo, pero voy a volver a poner el antiguo");
            genre.setGenreName(nombreAntiguo);
            em.merge(genre);
            System.out.println("Después de lanzar la segunda modificación");

            em.getTransaction().commit();


        }
    }
}
