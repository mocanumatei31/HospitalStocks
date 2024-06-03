package org.example.hospitalstocks.controllers;

import org.example.hospitalstocks.models.StockEntry;
import org.example.hospitalstocks.requestbodies.StockEntryConsumptionRequestBody;
import org.example.hospitalstocks.responsebodies.StockEntryResponseBody;
import org.example.hospitalstocks.services.StockEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
public class StockEntryController {
    @Autowired
    private StockEntryService stockEntryService;

    @GetMapping("/stocks")
    public List<StockEntryResponseBody> getStocks() {
        return stockEntryService.findAll();
    }

    @PutMapping("/stocks/update")
    public void UpdateStocks(@RequestBody StockEntryConsumptionRequestBody stockEntryConsumptionRequestBody) {
        stockEntryService.updateEntryOnConsumption(stockEntryConsumptionRequestBody);
    }

}
