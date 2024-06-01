package org.example.hospitalstocks.services;

import org.example.hospitalstocks.models.Manufacturer;
import org.example.hospitalstocks.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }
}
