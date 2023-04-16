package com.example.versiontaxe.service;

import com.example.versiontaxe.bean.TauxTaxeIS;
import com.example.versiontaxe.dao.TauxTaxeISDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class TauxTaxeISService {

    public TauxTaxeIS findByMontant(double montant) {
        return tauxTaxeISDao.findByMontant(montant);
    }

    @Autowired
    private TauxTaxeISDao tauxTaxeISDao;

    public List<TauxTaxeIS> findByDateApplicationDebutAndDateApplicationFin(double dateApplicationDebut , double dateApplicationFin) {
        return tauxTaxeISDao.findByDateApplicationDebutAndDateApplicationFin(dateApplicationDebut,dateApplicationFin);
    }

    public TauxTaxeIS findByBeneficeMaxAndBeneficeMinAndDateApplicationDebut(double beneficeMax, double beneficeMin, Date dateApplicationDebut) {
        return tauxTaxeISDao.findByBeneficeMaxAndBeneficeMinAndDateApplicationDebut(beneficeMax, beneficeMin, dateApplicationDebut);
    }

    @Transactional
    public int deleteByBeneficeMaxAndBeneficeMinAndDateApplicationDebut(double beneficeMin, double beneficeMax, Date dateApplicationDebut) {
        return tauxTaxeISDao.deleteByBeneficeMaxAndBeneficeMinAndDateApplicationDebut(beneficeMin, beneficeMax, dateApplicationDebut);
    }

    public List<TauxTaxeIS> findAll() {
        return tauxTaxeISDao.findAll();
    }


      /*  public double aplliquerTaux(double beneficeTotal) {
            List<TauxTaxeIS> tauxTaxeISList = tauxTaxeISDao.findAll();


            TauxTaxeIS tauxTaxeIS = null;
            for (TauxTaxeIS tt : tauxTaxeISList) {
                if (beneficeTotal >= tt.getBeneficeMin() && beneficeTotal <= tt.getBeneficeMax()) {
                    tauxTaxeIS = tt;
                    break;
                }
            }
            return tauxTaxeIS.getPourcentage();
        }*/


    public int save(TauxTaxeIS tauxTaxeIS) {
        if (findByMontant(tauxTaxeIS.getMontant()) != null) {
            return -1;
        } else {
            tauxTaxeISDao.save(tauxTaxeIS);
            return 1;
        }
    }


    public double getPourcentage(double montant) {
        TauxTaxeIS tauxTaxeIS = null;
        double pourcentage = 0.0, beneficeMax = 0.0, beneficeMin = 0.0;

        if (montant > 0 && montant <= 300000) {
            pourcentage = 0.1;
            beneficeMax = 300000.0;
          beneficeMin = 0.0;
        }
        if ( montant >= 300001 && montant < 1000000 ){
            pourcentage = 0.2;
            beneficeMax = 1000000.0;
            beneficeMin = 300001.0;
           }
        if( montant > 1000000){
            pourcentage = 0.31;

            beneficeMin = 1000000.0;
        }
        tauxTaxeIS.setPourcentage(pourcentage);
        tauxTaxeIS.setBeneficeMax(beneficeMax);
        tauxTaxeIS.setBeneficeMin(beneficeMin);
        tauxTaxeIS.setMontant(montant);

        this.save(tauxTaxeIS);
        return pourcentage;
       }


    }


