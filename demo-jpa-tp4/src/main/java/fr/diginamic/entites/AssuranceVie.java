package fr.diginamic.entites;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name="AssuranceVie")
public class AssuranceVie extends Compte {

    @Column(name = "taux")
    private double rate;

    @Column(name = "dateFin")
    private LocalDate endDate;

    public AssuranceVie() {}

    public AssuranceVie(double rate, LocalDate endDate) {
        this.rate = rate;
        this.endDate = endDate;
    }

    public AssuranceVie(Integer id, String number, double balance, double rate, LocalDate endDate) {
        super(id, number, balance);
        this.rate = rate;
        this.endDate = endDate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AssuranceVie{");
        sb.append("rate=").append(rate);
        sb.append(", endDate=").append(endDate);
        sb.append('}');
        return sb.toString();
    }
}
