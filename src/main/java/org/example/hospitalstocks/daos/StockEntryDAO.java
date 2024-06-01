package org.example.hospitalstocks.daos;

import org.example.hospitalstocks.models.StockEntry;
//import org.example.hospitalstocks.rowmappers.StockEntryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

//@Repository
//public class StockEntryDAO {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public List<StockEntry> getStockEntries() {
//        return jdbcTemplate.query("SELECT * FROM stock_entry s", new StockEntryRowMapper());
//    }
//
//    public StockEntry getStockEntryById(UUID id) {
//        return jdbcTemplate.queryForObject("SELECT * FROM stock_entry WHERE id = ?", new StockEntryRowMapper());
//    }
//
//    public void createStockEntry(StockEntry stockEntry) {
//        jdbcTemplate.update("INSERT INTO stock_entry VALUES(?, ?, ?, ?)", UUID.randomUUID(), stockEntry.getDrugId().toString(), stockEntry.getExpiryDate(), stockEntry.getQuantity());
//    }
//}
