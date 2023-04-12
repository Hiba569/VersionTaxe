package com.example.versiontaxe.dao;


import com.example.versiontaxe.bean.TauxTaxeIS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface TauxTaxeISDao extends JpaRepository<TauxTaxeIS, Long> {
    TauxTaxeIS findByBeneficeMaxAndBeneficeMinAndDateApplicationDebut
            (double beneficeMax, double beneficeMin,Date dateApplicationDebut);

    List<TauxTaxeIS> findByDateApplicationDebutAndDateApplicationFin(double dateAppclicationDebut , double dateApplicationFin);


    @Transactional
    int deleteByBeneficeMaxAndBeneficeMinAndDateApplicationDebut(double beneficeMin, double beneficeMax,Date dateApplicationDebut);
}
