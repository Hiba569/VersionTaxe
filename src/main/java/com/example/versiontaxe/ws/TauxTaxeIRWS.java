package com.example.versiontaxe.ws;
import com.example.versiontaxe.bean.TauxTaxeIR;
import com.example.versiontaxe.service.TauxTaxeIRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4/tauxTaxeIR")
public class TauxTaxeIRWS {
    @Autowired
    private TauxTaxeIRService tauxTaxeIRService;


    @GetMapping("/salaireBrutMin/{salaireBrutMin}/salaireBrutMax/{salaireBrutMax}")
    public TauxTaxeIR findBysalaireBrutMinAndSalaireBrutMax(@PathVariable double salaireBrutMin, @PathVariable double salaireBrutMax) {
        return tauxTaxeIRService.findBySalaireBrutMinAndSalaireBrutMax(salaireBrutMin, salaireBrutMax);
    }
    @GetMapping("/findAll")
    public List<TauxTaxeIR> findAll() {return tauxTaxeIRService.findAll();}

    @PutMapping("/pourcentageIR/totalSalaireBrut/{totalSalaireBrut}")
    public double pourcentageIR(@PathVariable int totalSalaireBrut) {
        return tauxTaxeIRService.pourcentageIR(totalSalaireBrut);
    }



}
