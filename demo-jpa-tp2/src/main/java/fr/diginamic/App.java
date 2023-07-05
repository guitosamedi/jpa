package fr.diginamic;
import fr.diginamic.entites.Livre;
import jakarta.persistence.*;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpql");
             EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            // Afficher Livre id 2
            Livre livre = em.find(Livre.class, 2);
            if (null != livre) {
                System.out.println(livre);
            }

            //Modifier Livre id 5
           Livre livreAModifier = em.find(Livre.class, 5);
            if (null != livreAModifier) {
              livreAModifier.setTitre("Du plaisir dans la cuisine");
            }

           // Requête JPQL READ BY TITRE
            TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.titre = 'Du plaisir dans la cuisine'", Livre.class);
            Livre l1 = query.getResultList().get(0);
            System.out.println(l1);

            // Requête JPQL READ BY AUTEUR
            TypedQuery<Livre> query2 = em.createQuery("select a from Livre a where a.auteur = ''", Livre.class);
            Livre l2 = query2.getResultList().get(0);
            System.out.println(l2);


            // DELETE LIVRE BY ID
            Livre livreASupprimer = em.find(Livre.class, 4);
            if (null != livreASupprimer) {
                em.remove(livreASupprimer);
            }

            // READ LIST
           TypedQuery<Livre> query3 = em.createQuery("select l from Livre l", Livre.class);
            for(Livre l3 : query3.getResultList()){
                System.out.println(l3);
            }

            em.getTransaction().commit();

            }
        }
}

