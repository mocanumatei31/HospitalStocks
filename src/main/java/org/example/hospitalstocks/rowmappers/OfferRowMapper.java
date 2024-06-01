package org.example.hospitalstocks.rowmappers;

import org.example.hospitalstocks.models.Offer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/*public class OfferRowMapper implements RowMapper<Offer> {

    @Override
    public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Offer offer = new Offer();
        offer.setId(rs.getString("id"));
        offer.setDrugId(UUID.fromString(rs.getString("drug_id")));
        offer.setPrice(rs.getDouble("price"));
        offer.setQuantity(rs.getInt("quantity"));
        return offer;
    }
}*/
