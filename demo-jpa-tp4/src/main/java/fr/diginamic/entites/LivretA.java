package fr.diginamic.entites;

import jakarta.persistence.*;

@Entity
@Table(name="LivretA")
public class LivretA extends Compte{
    @Column(name = "taux")
    private double rate;

    public LivretA() {}

    /* Doit-on créer un constructor pour rate ??
    public LivretA(double rate) {
        this.rate = rate;
    }
    */

    public LivretA(Integer id, String number, double balance, double rate) {
        super(id, number, balance);
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("LivretA{");
        sb.append("rate=").append(rate);
        sb.append('}');
        return sb.toString();
    }
}
