package org.example.hospitalstocks.controllers;

import org.example.hospitalstocks.models.StockEntry;
import org.example.hospitalstocks.responsebodies.StockEntryResponseBody;
import org.example.hospitalstocks.services.StockEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockEntryController {
    @Autowired
    private StockEntryService stockEntryService;

    @GetMapping("/stocks")
    public List<StockEntryResponseBody> getStocks() {
        return stockEntryService.findAll();
    }

}
