package fr.diginamic.entites;
import jakarta.persistence.*;

@Entity
@Table(name="livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="TITRE")
    private String titre;

    @Column(name="AUTEUR")
    private  String auteur;

    public Livre() {}


    public Integer getId() {
        return id;
    }

    public Livre(Integer id, String titre) {
        this.id = id;
        this.titre = titre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }


    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", TITRE='" + titre + '\'' +
                ", AUTEUR='" + auteur + '\'' +
                '}';
    }
}
