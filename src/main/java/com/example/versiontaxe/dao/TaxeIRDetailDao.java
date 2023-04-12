package com.example.versiontaxe.dao;

import com.example.versiontaxe.bean.TaxeIRDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeIRDetailDao extends JpaRepository<TaxeIRDetail, Long> {
    TaxeIRDetail findByEmployerCin(String cin);
    int deleteByEmployerCin(String cin);


}
