package com.example.versiontaxe.dao;

import com.example.versiontaxe.bean.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
public interface SocieteDao extends JpaRepository<Societe, Long> {

    Societe findByIce(int ice);
    @Transactional
    int deleteByIce(int ice);
}
