package org.example.hospitalstocks.repositories;


import org.example.hospitalstocks.models.StockEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockEntryRepository extends JpaRepository<StockEntry, String> {
}
