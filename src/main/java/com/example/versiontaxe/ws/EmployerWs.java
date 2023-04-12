package com.example.versiontaxe.ws;

import com.example.versiontaxe.bean.Employer;
import com.example.versiontaxe.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4/empl")
public class EmployerWs {
    @Autowired
    private EmployerService employerService;

    @GetMapping("/cin/{cin}")
    public Employer findByCin(@PathVariable String cin) {
        return employerService.findByCin(cin);
    }

    @DeleteMapping("/cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return employerService.deleteByCin(cin);
    }

    @GetMapping("/")
    public List<Employer> findAll() {
        return employerService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Employer employer) {
        return employerService.save(employer);
    }
}


