package com.example.versiontaxe.dao;

import com.example.versiontaxe.bean.Employer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Long> {

    Employer findByCin(String cin);
    @Transactional
    int deleteByCin(String cin);
}
