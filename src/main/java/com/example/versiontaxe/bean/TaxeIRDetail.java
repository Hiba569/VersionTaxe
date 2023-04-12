package com.example.versiontaxe.bean;

import javax.persistence.*;

@Entity
public class TaxeIRDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double salaireBrut;
    private double salaireNet;
    private double cotisationPatronale;
    private double cotisationSalariale;
    private double cotisationRetard;
    private double montantTauxIR;
    private double montantIREmployer;
    private int nombreMoisRetard;
    @ManyToOne
    private Employer employer;
    @ManyToOne
    private TaxeIR taxeIR;
    @ManyToOne
    private TauxTaxeIR tauxTaxeIR;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSalaireBrut() {
        return salaireBrut;
    }

    public void setSalaireBrut(double salaireBrut) {
        this.salaireBrut = salaireBrut;
    }

    public double getSalaireNet() {
        return salaireNet;
    }

    public void setSalaireNet(double salaireNet) {
        this.salaireNet = salaireNet;
    }

    public double getCotisationPatronale() {
        return cotisationPatronale;
    }

    public void setCotisationPatronale(double cotisationPatronale) {
        this.cotisationPatronale = cotisationPatronale;
    }

    public double getCotisationSalariale() {
        return cotisationSalariale;
    }

    public void setCotisationSalariale(double cotisationSalariale) {
        this.cotisationSalariale = cotisationSalariale;
    }

    public double getCotisationRetard() {
        return cotisationRetard;
    }

    public void setCotisationRetard(double cotisationRetard) {
        this.cotisationRetard = cotisationRetard;
    }

    public double getMontantTauxIR() {
        return montantTauxIR;
    }

    public void setMontantTauxIR(double montantTauxIR) {
        this.montantTauxIR = montantTauxIR;
    }

    public double getMontantIREmployer() {
        return montantIREmployer;
    }

    public void setMontantIREmployer(double montantIREmployer) {
        this.montantIREmployer = montantIREmployer;
    }

    public int getNombreMoisRetard() {
        return nombreMoisRetard;
    }

    public void setNombreMoisRetard(int nombreMoisRetard) {
        this.nombreMoisRetard = nombreMoisRetard;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public TaxeIR getTaxeIR() {
        return taxeIR;
    }

    public void setTaxeIR(TaxeIR taxeIR) {
        this.taxeIR = taxeIR;
    }

    public TauxTaxeIR getTauxTaxeIR() {
        return tauxTaxeIR;
    }

    public void setTauxTaxeIR(TauxTaxeIR tauxTaxeIR) {
        this.tauxTaxeIR = tauxTaxeIR;
    }
}
