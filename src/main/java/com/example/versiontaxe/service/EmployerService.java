package com.example.versiontaxe.service;

import com.example.versiontaxe.bean.Employer;
import com.example.versiontaxe.dao.EmployerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployerService {
    @Autowired
    private EmployerDao employerDao;

    public Employer findByCin(String cin) {
        return employerDao.findByCin(cin);
    }

    @Transactional
    public int deleteByCin(String cin) {
        return employerDao.deleteByCin(cin);
    }

    public List<Employer> findAll() {
        return employerDao.findAll();
    }

    public int save (Employer employer) {
        if (findByCin(employer.getCin()) != null)
            return -1;
        else {
            employerDao.save(employer);
            return 1;
        }
    }
}
