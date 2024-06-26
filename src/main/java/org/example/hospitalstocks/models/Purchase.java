package org.example.hospitalstocks.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hospitalstocks.requestbodies.OfferRequestBody;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PURCHASE")
public class Purchase {
    @Id
    @Size(max = 50)
    @Column(name = "ID", nullable = false, length = 50)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "DRUG_ID")
    private Drug drug;

    @Column(name = "PRICE", precision = 9, scale = 2)
    private BigDecimal price;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "DATE_BOUGHT")
    private LocalDate dateBought;


}