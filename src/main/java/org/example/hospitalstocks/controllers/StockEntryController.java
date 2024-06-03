package org.example.hospitalstocks.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.hospitalstocks.models.StockEntry;
import org.example.hospitalstocks.requestbodies.StockEntryConsumptionRequestBody;
import org.example.hospitalstocks.responsebodies.StockEntryResponseBody;
import org.example.hospitalstocks.services.StockEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Stock Entries Controller", description = "Management of the Data regarding the Hospital's Stock of Drugs")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
public class StockEntryController {
    @Autowired
    private StockEntryService stockEntryService;

    @Operation(summary = "Retrieves the hospital's stocks",
                description = "Returns a list showing information regarding the Hospital's Stock of Drugs," +
                        " including statistical data and projections about consumption")
    @GetMapping("/stocks")
    public List<StockEntryResponseBody> getStocks() {
        return stockEntryService.findAll();
    }

    @Operation(summary = "Updates a specific Stock",
                description = "Updates data about a Stock upon the consumption of one or more items in that specific stock")
    @PutMapping("/stocks/update")
    public void UpdateStocks(@RequestBody StockEntryConsumptionRequestBody stockEntryConsumptionRequestBody) {
        stockEntryService.updateEntryOnConsumption(stockEntryConsumptionRequestBody);
    }

}
