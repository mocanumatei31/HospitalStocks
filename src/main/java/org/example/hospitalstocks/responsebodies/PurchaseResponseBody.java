package org.example.hospitalstocks.responsebodies;

import lombok.Data;
import org.example.hospitalstocks.models.Drug;
import org.example.hospitalstocks.models.Purchase;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PurchaseResponseBody {
    private String id;
    private String drugName;
    private BigDecimal price;
    private Integer quantity;
    private LocalDate dateBought;
    public PurchaseResponseBody(Purchase purchase) {
        this.id = purchase.getId();
        this.drugName = purchase.getDrug().getName();
        this.price = purchase.getPrice();
        this.quantity = purchase.getQuantity();
        this.dateBought = purchase.getDateBought();
    }
}
