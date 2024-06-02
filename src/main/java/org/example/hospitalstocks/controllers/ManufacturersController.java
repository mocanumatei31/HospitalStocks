package org.example.hospitalstocks.controllers;


import org.example.hospitalstocks.models.Manufacturer;
import org.example.hospitalstocks.repositories.ManufacturerRepository;
import org.example.hospitalstocks.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManufacturersController {
    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/manufacturers")
    public List<Manufacturer> getAllManufacturers() {
        for(Manufacturer m : manufacturerService.getAllManufacturers()) {
            System.out.println(m);
        }
        return manufacturerService.getAllManufacturers();
    }
    @PostMapping("/manufacturers/add")
    public void addManufacturer(@RequestBody Manufacturer manufacturer) {
        manufacturerService.addManufacturer(manufacturer);
    }

    @DeleteMapping("/manufacturers/delete/{id}")
    public void deleteManufacturer(@PathVariable String id) {
        manufacturerService.deleteManufacturer(id);
    }
}
