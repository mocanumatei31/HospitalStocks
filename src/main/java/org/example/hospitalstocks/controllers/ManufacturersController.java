package org.example.hospitalstocks.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.hospitalstocks.models.Manufacturer;
import org.example.hospitalstocks.repositories.ManufacturerRepository;
import org.example.hospitalstocks.responsebodies.DrugResponseBody;
import org.example.hospitalstocks.responsebodies.ManufacturerResponseBody;
import org.example.hospitalstocks.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Manufacturers Controller", description = "Management of the Data about Manufacturers")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
public class ManufacturersController {
    @Autowired
    private ManufacturerService manufacturerService;

    @Operation(summary = "Get All Manufacturers", description = "Returns a list of all the Manufacturers kept in the Database")
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

    @Operation(summary = "Gets a Specific Manufacturer by its Name",
            description = "Shows an existing Manufacturer identified by its Name. Accepts the Name of the Manufacturer in the Path," +
                    " then returns data about said Manufacturer")
    @GetMapping("/manufacturers/{name}")
    public ManufacturerResponseBody getManufacturerByName(@PathVariable String name) {
        return manufacturerService.findManufacturerByName(name);
    }
}
