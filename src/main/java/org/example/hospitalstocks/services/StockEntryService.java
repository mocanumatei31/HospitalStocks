package org.example.hospitalstocks.services;

import org.example.hospitalstocks.models.Offer;
import org.example.hospitalstocks.models.StockEntry;
import org.example.hospitalstocks.repositories.StockEntryRepository;
import org.example.hospitalstocks.responsebodies.StockEntryResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StockEntryService {
    @Autowired
    private StockEntryRepository stockEntryRepository;
    public List<StockEntryResponseBody> findAll() {
        List<StockEntryResponseBody> stockEntries = new ArrayList<>();
        for (StockEntry stockEntry : stockEntryRepository.findAll()) {
            stockEntries.add(new StockEntryResponseBody(stockEntry));
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
    public void updateStockEntry(String id, StockEntry stockEntry) {
        Optional<StockEntry> stockEntryOptional = stockEntryRepository.findById(id);
        if (stockEntryOptional.isPresent()) {
            stockEntryOptional.get().setQuantity(stockEntry.getQuantity());
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
}
