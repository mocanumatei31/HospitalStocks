package org.example.hospitalstocks.responsebodies;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.example.hospitalstocks.models.Drug;
import org.example.hospitalstocks.models.StockEntry;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Data
public class StockEntryResponseBody {
    private String id;
    private String drugName;
    private LocalDate expiryDate;
    private Integer quantity;
    private Double daysTillDone;
    private Double dailyConsumption;
    public StockEntryResponseBody(StockEntry stockEntry, Double dailyConsumption,  Double daysTillDone) {
        this.id = stockEntry.getId();
        this.drugName = stockEntry.getDrug().getName();
        this.expiryDate = stockEntry.getExpiryDate();
        this.quantity = stockEntry.getQuantity();
        this.daysTillDone = daysTillDone;
        this.dailyConsumption = dailyConsumption;
    }
}
