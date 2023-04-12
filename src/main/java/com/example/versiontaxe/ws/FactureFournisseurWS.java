package com.example.versiontaxe.ws;

import com.example.versiontaxe.bean.FactureFournisseur;
import com.example.versiontaxe.service.FactureFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4/factureFournisseur")
public class FactureFournisseurWS {
    @Autowired
    private FactureFournisseurService factureFournisseurService;

    @PostMapping("/")

    public int save(@RequestBody FactureFournisseur factureFournisseur) {
        return factureFournisseurService.save(factureFournisseur);
    }
    @GetMapping("/code/{code}")
    public FactureFournisseur findByCode(@PathVariable String code) {
        return factureFournisseurService.findByCode(code);
    }
    @GetMapping("/ice/{ice}")
    public FactureFournisseur findByFournisseurIce(@PathVariable int ice) {
        return (FactureFournisseur) factureFournisseurService.findByFournisseurIce(ice);
    }


    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return factureFournisseurService.deleteByCode(code);
    }


    @GetMapping("/")
    public List<FactureFournisseur> findAll() {
        return factureFournisseurService.findAll();
    }
 /*   @PutMapping("/getTotalHorsTaxes/{code}/code")
    public double getTotalHorsTaxes(@PathVariable String code) {
        return factureFournisseurService.getTotalHorsTaxes(code);
    }*/
    @PutMapping("/getTotalHorsTaxes/{codes}/codes")
    public double getTotalHorsTaxes(@PathVariable List<String> codes) {
        return factureFournisseurService.getTotalHorsTaxes(codes);
    }}

