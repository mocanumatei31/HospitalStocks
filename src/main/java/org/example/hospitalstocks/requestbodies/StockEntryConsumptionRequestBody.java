package org.example.hospitalstocks.requestbodies;

import lombok.Data;

@Data
public class StockEntryConsumptionRequestBody {
    public String id;
    public Integer quantity;
}
