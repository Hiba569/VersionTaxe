package com.example.versiontaxe.service;

import com.example.versiontaxe.bean.TaxeIR;
import com.example.versiontaxe.bean.TaxeIRDetail;
import com.example.versiontaxe.dao.TaxeIRDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaxeIRService {
    @Autowired
    private TaxeIRDao taxeIRDao;
    @Autowired
    private TauxTaxeIRService tauxTaxeIRService;
    private TaxeIR taxeIR;

    public TaxeIR findBySocieteIceAndMoisAndAnnee(int ice, int mois, int annee) {
        return taxeIRDao.findBySocieteIceAndMoisAndAnnee(ice, mois, annee);
    }

    public List<TaxeIR> findAll() {
        return taxeIRDao.findAll();
    }

    public double taxeIRSomme(List<TaxeIRDetail> listIRdetail){
        double somme=0.0;
        for (TaxeIRDetail taxeIRDetail : listIRdetail) {
            somme += taxeIRDetail.getMontantIREmployer();
        }
        taxeIR.setMontantIRTotal(somme);
        return somme;
    }
    public int save(TaxeIR taxeIR){
        if(findBySocieteIceAndMoisAndAnnee(taxeIR.getSociete().getIce(), taxeIR.getMois(), taxeIR.getAnnee())!=null){
            return -1;
        }
        else{
            taxeIRDao.save(taxeIR);
            return 1;
        }
    }
}

