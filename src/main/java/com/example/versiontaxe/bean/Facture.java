package com.example.versiontaxe.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @OneToMany
    private List<FactureClient> listFactureClient;

    @OneToMany
    private  List<FactureFournisseur> listFactureFournisseur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<FactureClient> getListFactureClient() {
        return listFactureClient;
    }

    public void setListFactureClient(List<FactureClient> listFactureClient) {
        this.listFactureClient = listFactureClient;
    }

    public List<FactureFournisseur> getListFactureFournisseur() {
        return listFactureFournisseur;
    }

    public void setListFactureFournisseur(List<FactureFournisseur> listFactureFournisseur) {
        this.listFactureFournisseur = listFactureFournisseur;
    }
}
