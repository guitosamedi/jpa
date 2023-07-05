package fr.diginamic;
import fr.diginamic.entites.*;
import jakarta.persistence.*;

public class TestBibliotheque {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpql");
             EntityManager em = emf.createEntityManager()) {
             em.getTransaction().begin();

/*
            // JPDQL AFFICHER LISTE LIVRE
           TypedQuery<Livre> allLivre = em.createQuery("select l from Livre l", Livre.class);
            for(Livre livre : allLivre.getResultList()){
                System.out.println(livre);
            }

            Livre livre = em.find(Livre.class, 2);
            if (null != livre) {
                System.out.println(livre);
            }
*/
            Client client = em.find(Client.class, 2);
            if (null != client) {
            // Emprunts et client associé
                System.out.println(client);
                //System.out.println(client.getEmprunts());
            }

            Emprunt emprunt = em.find(Emprunt.class, 4);
            if (null != emprunt) {
                //Emprunt et livre associé
                System.out.println(emprunt);
            }

            em.getTransaction().commit();

            }
        }
}

