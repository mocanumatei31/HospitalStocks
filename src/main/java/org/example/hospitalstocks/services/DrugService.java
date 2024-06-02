package org.example.hospitalstocks.services;

import org.example.hospitalstocks.models.Drug;
import org.example.hospitalstocks.repositories.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DrugService {
    @Autowired
    private DrugRepository drugRepository;
    public List<Drug> getAllDrugs() {
        return drugRepository.findAll();
    }
    public void addDrug(Drug drug){
        drugRepository.save(drug);
    }
    public Drug findById(String id) {
        Optional<Drug> drug = drugRepository.findById(id);
        return drug.orElse(null);
    }

    public List<Drug> findByNameContaining(String name) {
        List<Drug> drugs = drugRepository.findByNameContaining(name);
        for(Drug d: drugs){
            System.out.println(d);
        }
        return drugs;
    }
}
