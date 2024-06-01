package org.example.hospitalstocks.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "OFFER")
public class Offer {
    @Id
    @Size(max = 40)
    @Column(name = "ID", nullable = false, length = 40)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "DRUG_ID")
    private Drug drug;

    @Column(name = "PRICE", precision = 9, scale = 2)
    private BigDecimal price;

    @Column(name = "QUANTITY")
    private Integer quantity;

}