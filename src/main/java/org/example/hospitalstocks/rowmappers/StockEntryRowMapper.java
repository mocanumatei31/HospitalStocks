package org.example.hospitalstocks.rowmappers;

import org.example.hospitalstocks.models.StockEntry;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

//public class StockEntryRowMapper implements RowMapper<StockEntry> {
//    @Override
//    public StockEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
//        StockEntry s = new StockEntry();
//        s.setId(UUID.fromString(rs.getString("id")));
//        s.setDrugId(UUID.fromString(rs.getString("drug_id")));
//        s.setQuantity(rs.getInt("quantity"));
//        s.setExpiry_date(rs.getDate("expiry_date").toLocalDate());
//        return s;
//    }
//}
