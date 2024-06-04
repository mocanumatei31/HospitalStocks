package org.example.hospitalstocks.responsebodies;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ConsumptionResponseBody {
    private String id;
    private String drugName;
    private Integer quantity;
    private LocalDate dateConsumed;
}
