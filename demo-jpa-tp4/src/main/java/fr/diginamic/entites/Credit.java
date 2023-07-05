package fr.diginamic.entites;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@DiscriminatorValue("Credit")
public class Credit extends Operation{

    @Column(name = "crediteur")
    private String creditor;

    public Credit(String creditor) {
        this.creditor = creditor;
    }

    public Credit(Integer id, LocalDateTime operationDate, double amount, String description, String operationType, String creditor) {
        super(id, operationDate, amount, description, operationType);
        this.creditor = creditor;
    }

    public Credit() {}

    public String getCreditor() {
        return creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Credit{");
        sb.append("creditor='").append(creditor).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
