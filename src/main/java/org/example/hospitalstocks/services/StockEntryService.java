package org.example.hospitalstocks.services;

import org.example.hospitalstocks.models.StockEntry;
import org.example.hospitalstocks.repositories.StockEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockEntryService {
    @Autowired
    private StockEntryRepository stockEntryRepository;
    public List<StockEntry> findAll() {
        return stockEntryRepository.findAll();
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
}
