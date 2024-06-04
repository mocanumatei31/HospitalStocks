package org.example.hospitalstocks.requestbodies;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class OfferRequestBody {
    private String id;
    private String drugName;
    private BigDecimal price;
    private Integer quantity;
    private LocalDate expiryDate;
}
