package fr.diginamic.entites;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name="Operation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "typeOperation")

public abstract class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOperation")
    private Integer id;

    @Column(name = "dateOperation")
    private LocalDateTime operationDate;

    @Column(name = "montant")
    private double amount;

    @Column(name = "motif")
    private String description;

    @Column(name = "typeOperation")
    private String operationType;

    public Operation(){}

    public Operation(Integer id, LocalDateTime operationDate, double amount, String description, String operationType) {
        this.id = id;
        this.operationDate = operationDate;
        this.amount = amount;
        this.description = description;
        this.operationType = operationType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDateTime operationDate) {
        this.operationDate = operationDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Operation{");
        sb.append("id=").append(id);
        sb.append(", operationDate=").append(operationDate);
        sb.append(", amount=").append(amount);
        sb.append(", description='").append(description).append('\'');
        sb.append(", operationType='").append(operationType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
