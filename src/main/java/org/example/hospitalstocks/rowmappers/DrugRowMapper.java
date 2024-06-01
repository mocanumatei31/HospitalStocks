package org.example.hospitalstocks.rowmappers;

import org.example.hospitalstocks.models.Drug;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

//public class DrugRowMapper implements RowMapper<Drug> {
//
//    @Override
//    public Drug mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Drug drug = new Drug();
//        drug.setId(UUID.fromString(rs.getString("id")));
//        drug.setName(rs.getString("name"));
//        drug.setDescription(rs.getString("description"));
//        drug.setCategory(rs.getString("category"));
//        drug.setDosage(rs.getString("dosage"));
//        drug.setType(rs.getString("type"));
//        drug.setManufacturerId(UUID.fromString(rs.getString("manufacturer_id")));
//        return drug;
//    }
//}
