package fr.diginamic.entites;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient")
    private Integer id;

    @Column(name = "nom")
    private String lastname;

    @Column(name = "prenom")
    private String firstname;

    @Column(name = "dateNaissance")
    private LocalDate birth;

    @Embedded
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name="idBanque")
    private Banque banque;



    @ManyToMany
    @JoinTable(name="Possede",
            joinColumns = @JoinColumn(name="idCompte", referencedColumnName = "idCompte"),
            inverseJoinColumns = @JoinColumn(name="idClient", referencedColumnName = "idClient")
    )
    private Set<Compte> comptes;

    public Client (){}

    public Client(Integer id, String lastname, String firstname, LocalDate birth, Adresse adresse, Banque banque, Set<Compte> comptes) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.birth = birth;
        this.adresse = adresse;
        this.banque = banque;
        this.comptes = comptes;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Client{");
        sb.append("id=").append(id);
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", firstname='").append(firstname).append('\'');
        sb.append(", birth=").append(birth);
        sb.append(", adresse=").append(adresse);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }


    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

}
