package com.example.versiontaxe.dao;



import com.example.versiontaxe.bean.FactureFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FactureFournisseurDao extends JpaRepository<FactureFournisseur,Long> {
    FactureFournisseur findByCode(String code);
    List<FactureFournisseur> findByFournisseurIce(int ice);
    @Transactional
    int deleteByCode(String code);

    @Override
    List<FactureFournisseur> findAll();


}
