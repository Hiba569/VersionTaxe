package com.example.versiontaxe.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TauxTaxeIS {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateApplicationDebut;
    private Date dateApplicationFin;
    private double montant;
    private double beneficeMax;
    private double beneficeMin;

    private double pourcentage;


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public Date getDateAplicationpDebut() {
        return dateApplicationDebut;
    }

    public void setDateAplicationpDebut(Date dateApplicationDebut) {
        this.dateApplicationDebut = dateApplicationDebut;
    }

    public Date getDateApplicationFin() {
        return dateApplicationFin;
    }

    public void setDateApplicationFin(Date dateApplicationFin) {
        this.dateApplicationFin = dateApplicationFin;
    }

    public double getBeneficeMax() {
        return beneficeMax;
    }

    public void setBeneficeMax(double beneficeMax) {
        this.beneficeMax = beneficeMax;
    }

    public double getBeneficeMin() {
        return beneficeMin;
    }

    public void setBeneficeMin(double beneficeMin) {
        this.beneficeMin = beneficeMin;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }

  



    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}





