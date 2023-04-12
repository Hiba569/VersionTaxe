package com.example.versiontaxe.service;

import com.example.versiontaxe.bean.FactureClient;
import com.example.versiontaxe.dao.FactureClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class FactureClientService {
    @Autowired
    private FactureClientDao factureClientDao;

    public int save(FactureClient factureClient){
        if (findByCode(factureClient.getCode()) != null){
            return -1;
        }else {
            factureClientDao.save(factureClient);
            return 1;
        }
    }

    public FactureClient findByCode(String code) {
        return factureClientDao.findByCode(code);
    }

    public List<FactureClient> findByClientIce(int ice) {
        return factureClientDao.findByClientIce(ice);
    }
    public List<FactureClient> findAll() {

        return factureClientDao.findAll();
    }

    @Transactional
    public int deleteByCode(String code) {
        return factureClientDao.deleteByCode(code);
    }




//    public int getTotalHorsTaxes(List<String> codes){
//        List<Double> totalHorsTaxesList = new ArrayList<>();
//        for (String code : codes) {
//            FactureClient factureClient = findByCode(code);
//            if (factureClient == null) {
//                return -1;
//            } else {
//                double montantTtc = factureClient.getMontantTtc();
//                double tva = factureClient.getTva();
//                double totalHorsTaxes = montantTtc / (1 + tva / 100);
//                factureClient.setMontantHt(totalHorsTaxes);
//                save(factureClient);
//            }
//        }
//        return 1;
//    }


public double getTotalHorsTaxes(String code){
        FactureClient factureClient=findByCode(code);

        if(factureClient==null){
            return -1;
        }
        else {

            double montantTtc =factureClient.getMontantTtc();
        double tva=factureClient.getTva();
        double totalHorsTaxes=montantTtc/(1+tva/100);
        factureClient.setMontantHt(totalHorsTaxes);
        save(factureClient);
        return  1;
        }

}
}
