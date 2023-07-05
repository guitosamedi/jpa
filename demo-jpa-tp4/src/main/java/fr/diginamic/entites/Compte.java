package fr.diginamic.entites;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="Compte")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {
    @Id
    @Column(name = "idCompte")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero")
    private String number;

     @Column(name = "solde")
    private double balance;

    @ManyToMany(mappedBy = "clients")
    private Set<Client> clients;

    public Compte(){}

    public Compte(Integer id, String number, double balance) {
        this.id = id;
        this.number = number;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Compte{");
        sb.append("id=").append(id);
        sb.append(", number='").append(number).append('\'');
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }
}
