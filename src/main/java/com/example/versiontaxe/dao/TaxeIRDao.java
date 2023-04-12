package com.example.versiontaxe.dao;

import com.example.versiontaxe.bean.TaxeIR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeIRDao extends JpaRepository<TaxeIR, Long> {
    TaxeIR findBySocieteIceAndMoisAndAnnee(int ice,int mois,int annee);
}
