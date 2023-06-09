package com.example.versiontaxe.ws;


import com.example.versiontaxe.bean.TauxTaxeIS;
import com.example.versiontaxe.service.TauxTaxeISService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v4/tauxTaxeIS")
public class TauxTaxeISWS {
   @GetMapping("/montant/{montant}")
    public TauxTaxeIS findByMontant(double montant) {
        return tauxTaxeISService.findByMontant(montant);
    }
    @PostMapping("/getPourcentage/montant/{montant}")
    public double getPourcentage(double montant) {
        return tauxTaxeISService.getPourcentage(montant);
    }

    @Autowired
    private TauxTaxeISService tauxTaxeISService;

    @GetMapping("/beneficeMax/{beneficeMax}/beneficeMin/{beneficeMin}/dateApplicationDebut/{dateApplicationDebut}")
    public TauxTaxeIS findByBeneficeMaxAndBeneficeMinAndDateApplicationDebut(@PathVariable double beneficeMax, @PathVariable double beneficeMin, @PathVariable Date dateApplicationDebut) {
        return tauxTaxeISService.findByBeneficeMaxAndBeneficeMinAndDateApplicationDebut(beneficeMax, beneficeMin, dateApplicationDebut);
    }

    @GetMapping("/dateAppDebut/{dateApplicationDebut}/dateAppFin/{dateApplicationFin}")
    public List<TauxTaxeIS> findByDateApplicationDebutAndDateApplicationFin(double dateApplicationDebut, double dateApplicationFin) {
        return tauxTaxeISService.findByDateApplicationDebutAndDateApplicationFin(dateApplicationDebut, dateApplicationFin);
    }

    @DeleteMapping("/beneficeMax/{beneficeMax}/beneficeMin/{beneficeMin}/dateApplicationDebut/{dateApplicationDebut}")
    public int deleteByBeneficeMaxAndBeneficeMinAndDateApplicationDebut(@PathVariable double beneficeMin,@PathVariable double beneficeMax,@PathVariable Date dateApplicationDebut) {
        return tauxTaxeISService.deleteByBeneficeMaxAndBeneficeMinAndDateApplicationDebut(beneficeMin, beneficeMax, dateApplicationDebut);
    }

    @GetMapping("/")
    public List<TauxTaxeIS> findAll() {
        return tauxTaxeISService.findAll();
    }

   /* @GetMapping("/aplliquerTaux/beneficeTotal/{beneficeTotal}")
    public double aplliquerTaux(@PathVariable double beneficeTotal) {
        return tauxTaxeISService.aplliquerTaux(beneficeTotal);
    }*/

    @PostMapping("/")
    public int save(@RequestBody TauxTaxeIS tauxTaxeIS) {
      return  tauxTaxeISService.save(tauxTaxeIS);
    }
}
