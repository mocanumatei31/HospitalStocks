package org.example.hospitalstocks.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.hospitalstocks.models.Drug;
import org.example.hospitalstocks.responsebodies.DrugResponseBody;
import org.example.hospitalstocks.services.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Drugs Controller", description = "Management of the Data about Drugs")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
public class DrugController {
    @Autowired
    DrugService drugService;

    @Operation(summary = "Get All Drugs", description = "Returns a list of all the Drugs kept in the Database")
    @GetMapping("/drugs")
    public List<Drug> getAllDrugs() {
        return drugService.getAllDrugs();
    }

    @GetMapping("/drugs/search/{name}")
    public List<Drug> getDrugByNameContaining(@PathVariable String name) {
        return drugService.findByNameContaining(name);
    }


    @Operation(summary = "Gets a Specific Drug by its Name",
            description = "Shows an existing Drug identified by its Name. Accepts the Name of the Drug in the Path," +
                    " then returns data about said Drug")
    @GetMapping("/drugs/{name}")
    public DrugResponseBody getDrugByName(@PathVariable String name) {
        return drugService.findByName(name);
    }
}
