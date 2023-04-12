package com.example.versiontaxe.service;

import com.example.versiontaxe.bean.TauxTaxeIR;
import com.example.versiontaxe.dao.TauxTaxeIRDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TauxTaxeIRService {
    @Autowired
    private TauxTaxeIRDao tauxTaxeIRDao;
    private TauxTaxeIR tauxTaxeIR;

    public TauxTaxeIR findBySalaireBrutMinAndSalaireBrutMax(double salaireBrutMin, double salaireBrutMax) {
        return tauxTaxeIRDao.findBySalaireBrutMinAndSalaireBrutMax(salaireBrutMin, salaireBrutMax);
    }
    public double pourcentageIR(int totalSalaireBrut) {
        double percentage = 0.0;
        switch (totalSalaireBrut) {
            case 0:
            case 1:
                // ...
            case 3000:
                percentage = 0.0;
                break;
            case 3001:
            case 3002:
                // ...
            case 4000:
                percentage = 0.1; // 10%
                break;
            case 4001:
            case 4002:
                // ...
            case 5000:
                percentage = 0.2; // 20%
                break;
            case 5001:
            case 5002:
                // ...
            case 6000:
                percentage = 0.3; // 30%
                break;
            case 6001:
            case 6002:
                // ...
            case 7000:
                percentage = 0.34; // 34%
                break;
            case 7001:
            case 7002:
                // ...
            case 8000:
                percentage = 0.38; // 38%
                break;
            case 8001:
            case 8002:
                // ...
            case 9000:
                percentage = 0.4; // 40%
                break;
            case 9001:
            case 9002:
                // ...
                percentage = 0.44; // 44%
                break;
            default:
                return -1;
        }
        tauxTaxeIR.setPourcentage(percentage);
        return percentage;
    }

    public List<TauxTaxeIR> findAll() {
        return tauxTaxeIRDao.findAll();
    }
}
