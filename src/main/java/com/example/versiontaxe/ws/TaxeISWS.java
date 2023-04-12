package com.example.versiontaxe.ws;

import com.example.versiontaxe.bean.Facture;
import com.example.versiontaxe.bean.TaxeIS;
import com.example.versiontaxe.service.TaxeISService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4/taxeis")
public class TaxeISWS {
    @Autowired
    private TaxeISService taxeISService;

    @GetMapping("/ice/{ice}/trimestre/{trimestre}")
    public TaxeIS findBySocieteIceAndTrimestre(@PathVariable int ice, @PathVariable int trimestre) {
        return taxeISService.findBySocieteIceAndTrimestre(ice, trimestre);
    }

    @DeleteMapping("/ice/{ice}/trimestre/{trimestre}")
    public int deleteBySocieteIceAndTrimestre(@PathVariable int ice,@PathVariable int trimestre) {
        return taxeISService.deleteBySocieteIceAndTrimestre(ice, trimestre);
    }

    @GetMapping("/")
    public List<TaxeIS> findAll() {
        return taxeISService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody TaxeIS taxeIS) {
        return taxeISService.save(taxeIS);
  }

    @PostMapping("/payerTaxe/facture/{facture}")
    public double payerTaxe(@RequestBody Facture facture) {
        return taxeISService.payerTaxe( facture);
    }
}
