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

    /**
     * Retrieves all Stock entries
     * @return the list of stock entries
     */
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

    /**
     * Finds a stock entry by its id
     * @param id the id to be searched for
     * @return
     */
    public StockEntry findById(String id) {
        Optional<StockEntry> stockEntry = stockEntryRepository.findById(id);
        return stockEntry.orElse(null);
    }
    public void deleteById(String id) {
        stockEntryRepository.deleteById(id);
    }

    /**
     * Updates the quantity of a stock entry
     * @param id the id of the stock entry
     * @param quantity the quantity that has been taken out
     */
    public void updateStockEntry(String id, Integer quantity) {
        Optional<StockEntry> stockEntryOptional = stockEntryRepository.findById(id);
        if (stockEntryOptional.isPresent()) {
            stockEntryOptional.get().setQuantity(stockEntryOptional.get().getQuantity() - quantity);
            if(stockEntryOptional.get().getQuantity() <= 0) {
                stockEntryRepository.delete(stockEntryOptional.get());
                return;
            }
            stockEntryRepository.save(stockEntryOptional.get());
        }
    }

    /**
     * Creates a stock entry from a purchased offer
     * @param offer the offer to be used
     */
    public void createStockEntryFromOffer(Offer offer) {
        StockEntry stockEntry = new StockEntry();
        stockEntry.setId(UUID.randomUUID().toString());
        stockEntry.setQuantity(offer.getQuantity());
        stockEntry.setExpiryDate(offer.getExpiryDate());
        stockEntry.setDrug(offer.getDrug());
        stockEntryRepository.save(stockEntry);
    }

    /**
     * Updates the quantity of the entry upon consumption of some of its stock
     * @param stockEntryConsumptionRequestBody the stock entry to be updated
     */
    public void updateEntryOnConsumption(StockEntryConsumptionRequestBody stockEntryConsumptionRequestBody){
        String id = stockEntryConsumptionRequestBody.getId().replace("\"", "");
        Integer quantity = stockEntryConsumptionRequestBody.getQuantity();
        consumptionService.getConsumptionFromStockEntry(findById(id), quantity);
        updateStockEntry(id, quantity);
    }

    /**
     * Returns the daily consumption of a stock entry
     * @param stockEntry the entry whose consumption is retrieved
     * @return the average daily consumption
     */
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

    /**
     * Retrieves the days left until the stock is depleted with the current average daily consumption
     * @param dailyConsumption the daily consumption of the stock
     * @param stockEntry the stock for which the data is retrieved
     * @return the days left until the stock is depleted with the current average daily consumption
     */
    public Double getDaysTillDone(Double dailyConsumption, StockEntry stockEntry) {
        Double remainingStock = Double.valueOf(stockEntry.getQuantity());
        return remainingStock / dailyConsumption;
    }
}
