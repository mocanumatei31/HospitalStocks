package org.example.hospitalstocks.services;

import org.example.hospitalstocks.models.Consumption;
import org.example.hospitalstocks.models.StockEntry;
import org.example.hospitalstocks.repositories.ConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ConsumptionService {
    @Autowired
    private ConsumptionRepository consumptionRepository;

    /**
     * Adds a consumption instance to the database
     * @param consumption the instance to be added
     */
    public void add(Consumption consumption) {
        consumptionRepository.save(consumption);
    }

    /**
     * Retreives all the consumption instances from the database
     * @return the list of instances
     */
    public List<Consumption> getConsumptions() {
        return consumptionRepository.findAll();
    }

    /**
     * Creates an instance of a consumption from a stock entry
     * @param stockEntry the stock entry to be converted
     * @param quantity the number of stock entries
     */
    public void getConsumptionFromStockEntry(StockEntry stockEntry, Integer quantity) {
        Consumption consumption = new Consumption();
        consumption.setId(UUID.randomUUID().toString());
        consumption.setDrug(stockEntry.getDrug());
        consumption.setQuantity(quantity);
        consumption.setDateConsumed(LocalDate.now());
        add(consumption);
    }
}
