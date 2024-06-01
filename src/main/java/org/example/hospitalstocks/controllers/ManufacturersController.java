package org.example.hospitalstocks.controllers;


import org.example.hospitalstocks.models.Manufacturer;
import org.example.hospitalstocks.repositories.ManufacturerRepository;
import org.example.hospitalstocks.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManufacturersController {
    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/manufacturers")
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerService.getAllManufacturers();
    }
}
