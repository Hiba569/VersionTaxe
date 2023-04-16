package com.example.versiontaxe.bean;


import javax.persistence.*;
import java.util.List;


@Entity
public class TaxeIR {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int mois;
    private int annee;
    private double montantIRTotal;
    private double nombreEmployerDeclare;
    //@OneToMany
     //private List<TauxTaxeIR> listTauxIR;
    @OneToMany
     private List<TaxeIRDetail> listIRdetail;
    @ManyToOne
    private Societe societe;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public double getMontantIRTotal() {
        return montantIRTotal;
    }

    public void setMontantIRTotal(double montantIRTotal) {
        this.montantIRTotal = montantIRTotal;
    }


    public double getNombreEmployerDeclare() {
        return nombreEmployerDeclare;
    }

    public void setNombreEmployerDeclare(double nombreEmployerDeclare) {
        this.nombreEmployerDeclare = nombreEmployerDeclare;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

}
