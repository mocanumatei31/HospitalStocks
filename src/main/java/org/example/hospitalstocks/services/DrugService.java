package org.example.hospitalstocks.services;

import org.example.hospitalstocks.models.Drug;
import org.example.hospitalstocks.repositories.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
