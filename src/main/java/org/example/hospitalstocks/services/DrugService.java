package org.example.hospitalstocks.services;

import org.example.hospitalstocks.models.Drug;
import org.example.hospitalstocks.repositories.DrugRepository;
import org.example.hospitalstocks.responsebodies.DrugResponseBody;
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
    public DrugResponseBody findById(String id) {
        Optional<Drug> optionalDrug = drugRepository.findById(id);
        Drug drug = optionalDrug.orElse(null);
        if(drug == null) return null;
        return new DrugResponseBody(drug);
    }

    public List<Drug> findByNameContaining(String name) {
        List<Drug> drugs = drugRepository.findByNameContaining(name);
        for(Drug d: drugs){
            System.out.println(d);
        }
        return drugs;
    }

    /**
     * Finds a drug by its name
     * @param name the name to be searched for
     * @return The drug instance with the searched for name
     */
    public DrugResponseBody findByName(String name) {
        return new DrugResponseBody(drugRepository.findByNameLike(name));
    }
}
