package org.example.hospitalstocks.daos;

import org.example.hospitalstocks.models.Drug;
//import org.example.hospitalstocks.rowmappers.DrugRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

//@Repository
//public class DrugDAO {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    public void create(Drug drug){
//        jdbcTemplate.update("INSERT INTO drug VALUES (?, ?, ?, ?, ?, ?, ?)",
//                UUID.randomUUID().toString(), drug.getName(), drug.getDescription(), drug.getCategory(),
//                drug.getDosage(), drug.getType(), drug.getManufacturerId().toString());
//    }
//    public Drug getDrugById(UUID id){
//        return jdbcTemplate.queryForObject("SELECT * FROM drug WHERE id = ?", new DrugRowMapper(), id.toString());
//    }
//
//    public Drug getDrugByName(String name){
//        return jdbcTemplate.queryForObject("SELECT * FROM drug WHERE name = ?", new DrugRowMapper(), name);
//    }
//
//    public void delete(UUID id){
//        jdbcTemplate.update("DELETE FROM drug WHERE id = ?", id.toString());
//    }
//}
