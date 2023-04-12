package com.example.versiontaxe.service;

import com.example.versiontaxe.bean.Societe;
import com.example.versiontaxe.dao.SocieteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SocieteService {


    @Autowired
    private SocieteDao societeDao;
    public Societe findByIce(int ice) {
        return societeDao.findByIce(ice);
    }

    @Transactional
    public int deleteByIce(int ice) {
        return societeDao.deleteByIce(ice);
    }

    public List<Societe> findAll() {
        return societeDao.findAll();
    }

    public int save (Societe societe) {
        if (findByIce(societe.getIce()) != null)
            return -1;
        else {
            societeDao.save(societe);
            return 1;
        }
    }
}
