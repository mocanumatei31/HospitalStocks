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

    public void add(Consumption consumption) {
        consumptionRepository.save(consumption);
    }

    public void getConsumptions() {
        List<Consumption> consumptions = consumptionRepository.findAll();
    }

    public void getConsumptionFromStockEntry(StockEntry stockEntry, Integer quantity) {
        Consumption consumption = new Consumption();
        consumption.setId(UUID.randomUUID().toString());
        consumption.setDrug(stockEntry.getDrug());
        consumption.setQuantity(quantity);
        consumption.setDateConsumed(LocalDate.now());
        add(consumption);
    }
}
