package com.example.versiontaxe.dao;


import com.example.versiontaxe.bean.TaxeIS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TaxeISDao extends JpaRepository<TaxeIS, Long> {

    TaxeIS findBySocieteIceAndTrimestre(int ice, int trimestre);

    @Transactional
    int deleteBySocieteIceAndTrimestre(int ice, int trimestre);


}
