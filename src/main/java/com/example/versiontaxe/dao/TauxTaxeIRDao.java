package com.example.versiontaxe.dao;

import com.example.versiontaxe.bean.TauxTaxeIR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxTaxeIRDao extends JpaRepository<TauxTaxeIR, Long> {
    TauxTaxeIR findBySalaireBrutMinAndSalaireBrutMax(double salaireBrutMin, double salaireBrutMax);
    TauxTaxeIR findByTotalSalaireBrut(double TotalSalaireBrut);

}
