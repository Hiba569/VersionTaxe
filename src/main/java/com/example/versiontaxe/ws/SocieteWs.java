package com.example.versiontaxe.ws;

import com.example.versiontaxe.bean.Societe;
import com.example.versiontaxe.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v4/soc")
public class SocieteWs {
    @Autowired
    private SocieteService societeService;

    @GetMapping("/ice/{ice}")
    public Societe findByIce(@PathVariable int ice) {
        return societeService.findByIce(ice);
    }

    @DeleteMapping("/ice/{ice}")
    public int deleteByIce( @PathVariable int ice) {
        return societeService.deleteByIce(ice);
    }

    @GetMapping("/")
    public List<Societe> findAll() {
        return societeService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Societe societe) {
        return societeService.save(societe);
    }
}
