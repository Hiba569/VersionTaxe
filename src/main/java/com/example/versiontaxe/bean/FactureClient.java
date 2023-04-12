package com.example.versiontaxe.bean;
import javax.persistence.*;
import java.util.Date;

@Entity
public class FactureClient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String code ;
    private double montantHt;
    private double montantTtc;
    private Date dateFacture;
    private double tva;
    @ManyToOne
    private Societe client;
    @ManyToOne
    private TaxeIS taxeIS;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getMontantHt() {
        return montantHt;
    }

    public void setMontantHt(double montantHt) {
        this.montantHt = montantHt;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public Societe getClient() {
        return client;
    }

    public void setClient(Societe client) {
        this.client = client;
    }
    public TaxeIS getTaxeIS() {
        return taxeIS;
    }

    public void setTaxeIS(TaxeIS taxeIS) {
        this.taxeIS = taxeIS;
    }

}
