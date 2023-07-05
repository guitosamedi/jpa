package fr.diginamic;
import fr.diginamic.entites.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        /** CNX Database **/
        try (
			 EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa-tp4");
             EntityManager em = emf.createEntityManager()){
             EntityTransaction transaction = em.getTransaction();
             transaction.begin();

             /** Test CNX **/
            System.out.println(em);

            /*
            Banque banque = em.find(Banque.class, 2);
            if (null != banque) {
                // Banque et client associé
                System.out.println(banque);
                //System.out.println(client.getClients());
            }*/

            /** Création d'une Banque **/
            Banque b = new Banque();
            b.setName("LCL");
            em.persist(b);

            /** Création d'un Livret A *
            LivretA la = new LivretA();
            la.setNumber("LFR4566988");
            la.setBalance(18997.60);
            la.setRate(3.5);
            em.persist(la);*/

            transaction.commit();
			em.close();
			emf.close();
        }
    }
}