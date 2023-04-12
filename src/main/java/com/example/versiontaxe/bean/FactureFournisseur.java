package com.example.versiontaxe.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
public class FactureFournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private double montantHT;
    private double montantTtc;
    private Date dateFacture;
    private double tva;
    @ManyToOne
    private TaxeIS taxeIS;
    @ManyToOne
    private Societe fournisseur;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getMontantHT() {
        return montantHT;
    }

    public void setMontantHT(double montantHT) {
        this.montantHT = montantHT;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getMontantTtc() {
        return montantTtc;
    }

    public void setMontantTtc(double montantTtc) {
        this.montantTtc = montantTtc;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }


    public Societe getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Societe fournisseur) {
        this.fournisseur = fournisseur;
    }
    public TaxeIS getTaxeIS() {
        return taxeIS;
    }

    public void setTaxeIS(TaxeIS taxeIS) {
        this.taxeIS = taxeIS;
    }
}
