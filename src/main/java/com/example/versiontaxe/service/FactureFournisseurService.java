package com.example.versiontaxe.service;

import com.example.versiontaxe.bean.FactureFournisseur;
import com.example.versiontaxe.dao.FactureFournisseurDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class FactureFournisseurService {
    @Autowired
    private FactureFournisseurDao factureFournisseurDao;
    public int save(FactureFournisseur factureFournisseur){
        if (findByCode(factureFournisseur.getCode()) != null){
            return -1;
        }else {
            factureFournisseurDao.save(factureFournisseur);
            return 1;
        }
    }

    public FactureFournisseur findByCode(String code) {
        return factureFournisseurDao.findByCode(code);
    }

    public List<FactureFournisseur> findByFournisseurIce(int ice) {
        return factureFournisseurDao.findByFournisseurIce(ice);
    }

    @Transactional
    public int deleteByCode(String code) {
        return factureFournisseurDao.deleteByCode(code);
    }


    public List<FactureFournisseur> findAll() {
        return factureFournisseurDao.findAll();
    }

    public int getTotalHorsTaxes(List<String> codes){
        List<Double> totalHorsTaxesList = new ArrayList<>();
        for (String code : codes) {
            FactureFournisseur factureFournisseur = findByCode(code);
            if (factureFournisseur == null) {
                return -1;
            } else {
                double montantTtc = factureFournisseur.getMontantTtc();
                double tva = factureFournisseur.getTva();
                double totalHorsTaxes = montantTtc / (1 + tva / 100);
                factureFournisseur.setMontantHT(totalHorsTaxes);
                save(factureFournisseur);
            }
        }
        return 1;
    }

     /*   public double getTotalHorsTaxes(String code){
        FactureFournisseur factureFournisseur=findByCode(code);

        if(factureFournisseur==null){
            return -1;
        }
        else {
            double montantTtc =factureFournisseur.getMontantTtc();
            double tva=factureFournisseur.getTva();
            double totalHorsTaxes=montantTtc/(1+tva/100);
            factureFournisseur.setMontantHT(totalHorsTaxes);
            save(factureFournisseur);
            return  1;

        }
    }*/

}
