package com.example.versiontaxe.ws;


import com.example.versiontaxe.bean.FactureClient;
import com.example.versiontaxe.service.FactureClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v4/factureClient")

public class FactureClientWS {

    @Autowired
    private FactureClientService factureClientService;

    @PostMapping("/")
    public int save(@RequestBody FactureClient factureClient) {
        return factureClientService.save(factureClient);
    }

    @GetMapping("/code/{code}")
    public FactureClient findByCode(@PathVariable String code) {
        return factureClientService.findByCode(code);
    }

    @GetMapping("/ice/{ice}")
    public FactureClient findByClientIce(@PathVariable int ice) {
        return (FactureClient) factureClientService.findByClientIce(ice);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code)
    {
        return factureClientService.deleteByCode(code);
    }


    @GetMapping("/")
    public List<FactureClient> findAll() {
        return factureClientService.findAll();
    }
    @PutMapping("/getTotalHorsTaxes/{code}/code")
    public double getTotalHorsTaxes(@PathVariable String code) {
        return factureClientService.getTotalHorsTaxes(code);
    }
//    @PutMapping("/getTotalHorsTaxes/{codes}/codes")
//    public double getTotalHorsTaxes(@PathVariable List<String> codes) {
//        return factureClientService.getTotalHorsTaxes(codes);
//    }
}


