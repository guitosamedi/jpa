package fr.diginamic.entites;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@DiscriminatorValue("Débit")
public class Debit extends Operation {

    @Column(name = "debiteur")
    private String debtor;

    public Debit(String debtor) {
        this.debtor = debtor;
    }

    public Debit(Integer id, LocalDateTime operationDate, double amount, String description, String operationType, String debtor) {
        super(id, operationDate, amount, description, operationType);
        this.debtor = debtor;
    }

    public Debit() {}

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Debit{");
        sb.append("debtor='").append(debtor).append('\'');
        sb.append('}');
        return sb.toString();
    }
}