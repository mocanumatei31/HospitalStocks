package org.example.hospitalstocks.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "STOCK_ENTRY")
public class StockEntry {
    @Id
    @Size(max = 40)
    @Column(name = "ID", nullable = false, length = 40)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "DRUG_ID")
    private Drug drug;

    @Column(name = "EXPIRY_DATE")
    private LocalDate expiryDate;

    @Column(name = "QUANTITY")
    private Integer quantity;

}