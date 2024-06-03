package org.example.hospitalstocks.services;

import org.example.hospitalstocks.models.Consumption;
import org.example.hospitalstocks.models.Offer;
import org.example.hospitalstocks.models.Purchase;
import org.example.hospitalstocks.models.StockEntry;
import org.example.hospitalstocks.repositories.StockEntryRepository;
import org.example.hospitalstocks.requestbodies.StockEntryConsumptionRequestBody;
import org.example.hospitalstocks.responsebodies.StockEntryResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StockEntryService {
    @Autowired
    private StockEntryRepository stockEntryRepository;
    @Autowired
    private ConsumptionService consumptionService;
    @Autowired
    private PurchaseService purchaseService;

    public List<StockEntryResponseBody> findAll() {
        List<StockEntryResponseBody> stockEntries = new ArrayList<>();
        for (StockEntry stockEntry : stockEntryRepository.findAll()) {
            stockEntries.add(new StockEntryResponseBody(stockEntry, getDailyConsumption(stockEntry), getDaysTillDone(getDailyConsumption(stockEntry), stockEntry)));
        }
        return stockEntries;
    }
    public StockEntry save(StockEntry stockEntry) {
        return stockEntryRepository.save(stockEntry);
    }
    public StockEntry findById(String id) {
        Optional<StockEntry> stockEntry = stockEntryRepository.findById(id);
        return stockEntry.orElse(null);
    }
    public void deleteById(String id) {
        stockEntryRepository.deleteById(id);
    }
    public void updateStockEntry(String id, Integer quantity) {
        Optional<StockEntry> stockEntryOptional = stockEntryRepository.findById(id);
        if (stockEntryOptional.isPresent()) {
            stockEntryOptional.get().setQuantity(stockEntryOptional.get().getQuantity() - quantity);
            if(stockEntryOptional.get().getQuantity() <= 0) {
                stockEntryRepository.delete(stockEntryOptional.get());
            }
            stockEntryRepository.save(stockEntryOptional.get());
        }
    }
    public void createStockEntryFromOffer(Offer offer) {
        StockEntry stockEntry = new StockEntry();
        stockEntry.setId(UUID.randomUUID().toString());
        stockEntry.setQuantity(offer.getQuantity());
        stockEntry.setExpiryDate(offer.getExpiryDate());
        stockEntry.setDrug(offer.getDrug());
        stockEntryRepository.save(stockEntry);
    }

    public void updateEntryOnConsumption(StockEntryConsumptionRequestBody stockEntryConsumptionRequestBody){
        String id = stockEntryConsumptionRequestBody.getId().replace("\"", "");
        Integer quantity = stockEntryConsumptionRequestBody.getQuantity();
        consumptionService.getConsumptionFromStockEntry(findById(id), quantity);
        updateStockEntry(id, quantity);
    }

    public Double getDailyConsumption(StockEntry stockEntry) {
        Integer counter = 0;
        for(Consumption c : consumptionService.getConsumptions()){
            if(c.getDrug().equals(stockEntry.getDrug())){
                counter += c.getQuantity();
            }
        }
        LocalDate min = LocalDate.now();
        for(Purchase p : purchaseService.getNormalPurchases()) {
            if(p.getDrug().equals(stockEntry.getDrug())) {
                min = min.isBefore(p.getDateBought()) ? min : p.getDateBought();
            }

        }
        long daysBetween = ChronoUnit.DAYS.between(min, LocalDate.now());
        Double doubleCounter = Double.valueOf(counter);
        Double doubleDaysBetween = (double) daysBetween;
        if(daysBetween == 0){
            return null;
        }
        else{
            return doubleCounter / doubleDaysBetween;
        }
    }

    public Double getDaysTillDone(Double dailyConsumption, StockEntry stockEntry) {
        Double remainingStock = Double.valueOf(stockEntry.getQuantity());
        return remainingStock / dailyConsumption;
    }
}
