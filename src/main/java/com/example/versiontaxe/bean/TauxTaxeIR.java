package com.example.versiontaxe.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TauxTaxeIR {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateApplicationDebut;
    private Date dateApplicationFin;
    private double salaireBrutMin;
    private double salaireBrutMax;
    private int totalSalaireBrut;
    private double pourcentage;
    private double montantRetard;
    private int nombreMoisRetard;
    private double pourcentageMajoration;
    private double pourcentageCotisationPatronale;
    private double pourcentageCotisationSalariale;
//    @OneToMany
//    private List<TaxeIRDetail> listIRdetail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateApplicationDebut() {
        return dateApplicationDebut;
    }

    public void setDateApplicationDebut(Date dateApplicationDebut) {
        this.dateApplicationDebut = dateApplicationDebut;
    }

    public Date getDateApplicationFin() {
        return dateApplicationFin;
    }

    public void setDateApplicationFin(Date dateApplicationFin) {
        this.dateApplicationFin = dateApplicationFin;
    }

    public double getSalaireBrutMin() {
        return salaireBrutMin;
    }

    public void setSalaireBrutMin(double salaireBrutMin) {
        this.salaireBrutMin = salaireBrutMin;
    }

    public double getSalaireBrutMax() {
        return salaireBrutMax;
    }

    public void setSalaireBrutMax(double salaireBrutMax) {
        this.salaireBrutMax = salaireBrutMax;
    }

    public int getTotalSalaireBrut() {
        return totalSalaireBrut;
    }

    public void setTotalSalaireBrut(int totalSalaireBrut) {
        this.totalSalaireBrut = totalSalaireBrut;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }

    public double getMontantRetard() {
        return montantRetard;
    }

    public void setMontantRetard(double montantRetard) {
        this.montantRetard = montantRetard;
    }

    public int getNombreMoisRetard() {
        return nombreMoisRetard;
    }

    public void setNombreMoisRetard(int nombreMoisRetard) {
        this.nombreMoisRetard = nombreMoisRetard;
    }

    public double getPourcentageMajoration() {
        return pourcentageMajoration;
    }

    public void setPourcentageMajoration(double pourcentageMajoration) {
        this.pourcentageMajoration = pourcentageMajoration;
    }

    public double getPourcentageCotisationPatronale() {
        return pourcentageCotisationPatronale;
    }

    public void setPourcentageCotisationPatronale(double pourcentageCotisationPatronale) {
        this.pourcentageCotisationPatronale = pourcentageCotisationPatronale;
    }

    public double getPourcentageCotisationSalariale() {
        return pourcentageCotisationSalariale;
    }

    public void setPourcentageCotisationSalariale(double pourcentageCotisationSalariale) {
        this.pourcentageCotisationSalariale = pourcentageCotisationSalariale;
    }

//    public List<TaxeIRDetail> getListIRdetail() {
//        return listIRdetail;
//    }
//
//    public void setListIRdetail(List<TaxeIRDetail> listIRdetail) {
//        this.listIRdetail = listIRdetail;
//    }
}