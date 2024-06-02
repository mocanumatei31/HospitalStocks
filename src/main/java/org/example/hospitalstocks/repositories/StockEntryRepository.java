package org.example.hospitalstocks.repositories;


import org.example.hospitalstocks.models.StockEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockEntryRepository extends JpaRepository<StockEntry, String> {
}
