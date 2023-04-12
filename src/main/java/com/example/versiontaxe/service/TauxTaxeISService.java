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


        public double aplliquerTaux(double beneficeTotal) {
            List<TauxTaxeIS> tauxTaxeISList = tauxTaxeISDao.findAll();


            TauxTaxeIS tauxTaxeIS = null;
            for (TauxTaxeIS tt : tauxTaxeISList) {
                if (beneficeTotal >= tt.getBeneficeMin() && beneficeTotal <= tt.getBeneficeMax()) {
                    tauxTaxeIS = tt;
                    break;
                }
            }
            return tauxTaxeIS.getPourcentage();
        }

        public void save(TauxTaxeIS tauxTaxeIS) {
            tauxTaxeISDao.save(tauxTaxeIS);
        }



    }


