package com.example.versiontaxe.service;

import com.example.versiontaxe.bean.*;
import com.example.versiontaxe.dao.TaxeISDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaxeISService {
    @Autowired
    private TaxeISDao taxeISDao;
    @Autowired
    private TauxTaxeISService tauxTaxeISService;

    public TaxeIS findBySocieteIceAndTrimestre(int ice, int trimestre) {
        return taxeISDao.findBySocieteIceAndTrimestre(ice, trimestre);
    }

    @Transactional
    public int deleteBySocieteIceAndTrimestre(int ice, int trimestre) {
        return taxeISDao.deleteBySocieteIceAndTrimestre(ice, trimestre);}

    public List<TaxeIS> findAll() {
        return taxeISDao.findAll();
    }

    public int save(TaxeIS taxeIS) {
        if (findBySocieteIceAndTrimestre(taxeIS.getSociete().getIce(), taxeIS.getTrimestre()) != null) {
            return -1;
        } else {
            taxeISDao.save(taxeIS);
            return 1;
        }
    }

    public double payerTaxe(Facture facture  ) {

        double totalFactureClient =0.0 ;
        double totalFactureFournisseur = 0.0;

        for (FactureClient factureClient : facture.getListFactureClient()) {
            totalFactureClient += factureClient.getMontantHt();
        }

        for (FactureFournisseur factureFournisseur : facture.getListFactureFournisseur()) {
            totalFactureFournisseur += factureFournisseur.getMontantHT();
        }

        double benefice = totalFactureFournisseur - totalFactureClient;
        TaxeIS taxeIS = new TaxeIS();

       double x= benefice * tauxTaxeISService.aplliquerTaux(benefice);
        if (x < 3000) {
            taxeIS.setMontantIS(3000);// Return 30000Dh as tax amount
        }
        taxeIS.setMontantIS(x);
        taxeIS.setResultatAvantImpot(benefice);
        taxeIS.setResultatApresImpot(benefice - taxeIS.getMontantIS());

        return taxeIS.getMontantIS();

    }
}
