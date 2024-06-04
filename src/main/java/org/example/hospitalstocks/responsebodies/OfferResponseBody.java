package org.example.hospitalstocks.responsebodies;

import lombok.Data;
import org.example.hospitalstocks.models.Offer;
import org.springframework.data.relational.core.sql.In;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OfferResponseBody {
    private String id;
    private String drugName;
    private BigDecimal price;
    private Integer quantity;
    private LocalDate expiryDate;
    public OfferResponseBody(Offer offer) {
        this.id = offer.getId();
        this.drugName = offer.getDrug().getName();
        this.price = offer.getPrice();
        this.quantity = offer.getQuantity();
        this.expiryDate = offer.getExpiryDate();
    }
}
