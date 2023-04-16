package com.example.versiontaxe.ws;

import com.example.versiontaxe.bean.TaxeIRDetail;
import com.example.versiontaxe.service.TaxeIRDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4/taxeirdetail")
public class TaxeIRDetailWS {
    @Autowired
    private TaxeIRDetailService taxeIRDetailService;
    @GetMapping("/cin/{cin}")
    public TaxeIRDetail findByEmployerCin(@PathVariable String cin) {
        return taxeIRDetailService.findByEmployerCin(cin);
    }
    @PostMapping("/")
    public int save(@RequestBody TaxeIRDetail taxeIRDetail) {
        return taxeIRDetailService.save(taxeIRDetail);}

    @GetMapping("/findAll")
    public List<TaxeIRDetail> findAll() {
        return taxeIRDetailService.findAll();
    }

    @PutMapping("/calculMontantIR/salaireBrut/{salaireBrut}")
    public double calculMontantIR(@PathVariable int salaireBrut) {
        return taxeIRDetailService.calculMontantIR(salaireBrut);
    }
    @PutMapping("/calculCotisationRetard/salaireBrut/{salaireBrut}")
    public double calculCotisationRetard(@PathVariable double salaireBrut) {
        return taxeIRDetailService.calculCotisationRetard(salaireBrut);
    }
    @PutMapping("/montantIRtotalEmployer/cotisationRetard/{cotisationRetard}")
    public double montantIRtotalEmployer() {
        return taxeIRDetailService.montantIRtotalEmployer();
    }

    @DeleteMapping("/cin/{cin}")
    public int deleteByEmployerCin(@PathVariable String cin) {
        return taxeIRDetailService.deleteByEmployerCin(cin);
    }
}
