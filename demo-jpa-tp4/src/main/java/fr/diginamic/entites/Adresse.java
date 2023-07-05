package fr.diginamic.entites;

import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {
    private Integer numero;
    private String rue;
    private String ville;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Adresse{");
        sb.append("numero=").append(numero);
        sb.append(", rue='").append(rue).append('\'');
        sb.append(", ville='").append(ville).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
