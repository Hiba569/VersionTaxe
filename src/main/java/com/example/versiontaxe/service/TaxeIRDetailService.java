package com.example.versiontaxe.service;
import com.example.versiontaxe.bean.TauxTaxeIR;
import com.example.versiontaxe.bean.TaxeIRDetail;
import com.example.versiontaxe.dao.TaxeIRDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxeIRDetailService {
    @Autowired
    private TaxeIRDetailDao taxeIRDetailDao;
    private TauxTaxeIRService tauxTaxeIRService;
    private TauxTaxeIR tauxTaxeIR;
    private TaxeIRDetail taxeIRDetail;

    public TaxeIRDetail findByEmployerCin(String cin) {
        return taxeIRDetailDao.findByEmployerCin(cin);
    }

    public List<TaxeIRDetail> findAll() {
        return taxeIRDetailDao.findAll();
    }
    public int save(TaxeIRDetail taxeIRDetail){
        if(findByEmployerCin(taxeIRDetail.getEmployer().getCin())!=null){
            return -1;}
        else {
                taxeIRDetailDao.save(taxeIRDetail);
                return 1;}
        }
    public double calculMontantIR(int salaireBrut){
        double result= salaireBrut*tauxTaxeIRService.pourcentageIR(salaireBrut);
        taxeIRDetail.setMontantTauxIR(result);
        return result;
    }
    public double calculCotisationRetard(double salaireBrut){
        if(taxeIRDetail.getNombreMoisRetard()==0)   {
            taxeIRDetail.setCotisationRetard(0);
            return 0;
        }
        else{
        double majoration = 0.05;
        double result =(taxeIRDetail.getMontantTauxIR()*majoration)+0.01*salaireBrut*(taxeIRDetail.getNombreMoisRetard()-1);
        taxeIRDetail.setCotisationRetard(result);
        return result;
        }
    }
    public double montantIRtotalEmployer(){
         double total = taxeIRDetail.getMontantTauxIR()+tauxTaxeIR.getMontantRetard()+taxeIRDetail.getCotisationRetard();
         taxeIRDetail.setMontantIREmployer(total);
         return total;
    }
    public int deleteByEmployerCin(String cin) {
        return taxeIRDetailDao.deleteByEmployerCin(cin);
    }
}
