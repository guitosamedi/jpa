package fr.diginamic.entites;


import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@DiscriminatorValue("Virement")
public class Virement extends Operation {

    @Column(name = "beneficiaire")
    private String beneficiary;

    public Virement(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Virement(Integer id, LocalDateTime operationDate, double amount, String description, String operationType, String beneficiary) {
        super(id, operationDate, amount, description, operationType);
        this.beneficiary = beneficiary;
    }

    public Virement() {}

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Virement{");
        sb.append("beneficiary='").append(beneficiary).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
