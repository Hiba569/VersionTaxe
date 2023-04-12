package com.example.versiontaxe.ws;
import com.example.versiontaxe.bean.TaxeIR;
import com.example.versiontaxe.bean.TaxeIRDetail;
import com.example.versiontaxe.service.TaxeIRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4/taxeIR")
public class TaxeIRWS {
    @Autowired
    private TaxeIRService taxeIRService;

    @GetMapping("/ice/{ice}/mois/{mois}/annee/{annee}")
    public TaxeIR findBySocieteIceAndMoisAndAnnee(@PathVariable int ice, @PathVariable int mois, @PathVariable int annee) {
        return taxeIRService.findBySocieteIceAndMoisAndAnnee(ice, mois, annee);}
    @PostMapping("/")
    public int save(@RequestBody TaxeIR taxeIR) {
        return taxeIRService.save(taxeIR);}
    @GetMapping("/findAll")
    public List<TaxeIR> findAll() {
        return taxeIRService.findAll();
    }

    @PutMapping("/taxeIRSomme/listIRdetail/{listIRdetail}")
    public double taxeIRSomme(@RequestBody List<TaxeIRDetail> listIRdetail) {
        return taxeIRService.taxeIRSomme(listIRdetail);}
}
