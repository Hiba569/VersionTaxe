package com.example.versiontaxe.bean;


import javax.persistence.*;
import java.util.Date;

@Entity
public class TaxeIS {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private int trimestre;
    private Date datePaiement;
    private double montantIS;
    private String cahierCharge;

    private int charge;

    private double resultatApresImpot;
    private double resultatAvantImpot;
    @ManyToOne
    private TauxTaxeIS tauxTaxeIS;
    @ManyToOne

    private Societe societe ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public double getMontantIS() {
        return montantIS;
    }

    public void setMontantIS(double montantIS) {
        this.montantIS = montantIS;
    }

    public String getCahierCharge() {
        return cahierCharge;
    }

    public void setCahierCharge(String cahierCharge) {
        this.cahierCharge = cahierCharge;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public double getResultatApresImpot() {
        return resultatApresImpot;
    }

    public void setResultatApresImpot(double resultatApresImpot) {
        this.resultatApresImpot = resultatApresImpot;
    }

    public double getResultatAvantImpot() {
        return resultatAvantImpot;
    }

    public void setResultatAvantImpot(double resultatAvantImpot) {
        this.resultatAvantImpot = resultatAvantImpot;
    }

    public TauxTaxeIS getTauxTaxeIS() {
        return tauxTaxeIS;
    }

    public void setTauxTaxeIS(TauxTaxeIS tauxTaxeIS) {
        this.tauxTaxeIS = tauxTaxeIS;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }
}
