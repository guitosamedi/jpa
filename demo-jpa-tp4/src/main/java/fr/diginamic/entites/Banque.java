package fr.diginamic.entites;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="Banque")
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBanque")
    private Integer id;

    @Column(name="nom")
    private String name;

    @OneToMany(mappedBy = "banque")
    private Set<Client> clients= new HashSet<>();

    public Banque(){}

    public Banque(Integer id, String name, Set<Client> clients) {
        this.id = id;
        this.name = name;
        this.clients = clients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Banque{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", clients=").append(clients);
        sb.append('}');
        return sb.toString();
    }
}
