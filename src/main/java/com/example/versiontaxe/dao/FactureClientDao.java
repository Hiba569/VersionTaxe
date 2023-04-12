package com.example.versiontaxe.dao;


import com.example.versiontaxe.bean.FactureClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FactureClientDao extends JpaRepository<FactureClient,Long> {
    FactureClient findByCode(String code);
    List<FactureClient> findByClientIce(int ice);

    @Override
    List<FactureClient> findAll();

    @Transactional
    int deleteByCode(String code);



}
