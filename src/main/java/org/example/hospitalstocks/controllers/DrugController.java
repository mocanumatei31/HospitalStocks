package org.example.hospitalstocks.controllers;

import org.example.hospitalstocks.models.Drug;
import org.example.hospitalstocks.responsebodies.DrugResponseBody;
import org.example.hospitalstocks.services.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DrugController {
    @Autowired
    DrugService drugService;

    @GetMapping("/drugs")
    public List<Drug> getAllDrugs() {
        for(Drug d : drugService.getAllDrugs()){
            System.out.println(d);
        }
        return drugService.getAllDrugs();
    }

    @GetMapping("/drugs/{id}")
    public DrugResponseBody getDrugById(@PathVariable String id) {
        return drugService.findById(id);
    }

    @GetMapping("/drugs/search/{name}")
    public List<Drug> getDrugByNameLike(@PathVariable String name) {
        return drugService.findByNameContaining(name);
    }
}
