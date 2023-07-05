package fr.diginamic.entites;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name="emprunt")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DATE_DEBUT")
    private LocalDateTime dateDebut;

    @Column(name = "DATE_FIN")
    private LocalDateTime dateFin;

    @Column(name = "DELAI")
    private Integer delai;

    @ManyToOne
    @JoinColumn(name="ID_CLIENT")
    private Client client;

    @ManyToMany
    @JoinTable(name="compo",
    joinColumns = @JoinColumn(name="ID_EMP", referencedColumnName = "ID"),
    inverseJoinColumns = @JoinColumn(name="ID_LIV", referencedColumnName = "ID")
    )

    private Set<Livre> livres;

    public Emprunt() {}
    public Emprunt(Integer id, LocalDateTime dateDebut, LocalDateTime dateFin, Integer delai, Client client) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.delai = delai;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getDelai() {
        return delai;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Emprunt{");
        sb.append("id=").append(id);
        sb.append(", dateDebut=").append(dateDebut);
        sb.append(", dateFin=").append(dateFin);
        sb.append(", delai=").append(delai);
        sb.append(", livres=").append(livres);
        sb.append('}');
        return sb.toString();
    }
}
