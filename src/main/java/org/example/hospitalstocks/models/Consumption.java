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
@Table(name = "CONSUMPTION")
public class Consumption {
    @Id
    @Size(max = 50)
    @Column(name = "ID", nullable = false, length = 50)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "DRUG_ID")
    private Drug drug;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "DATE_CONSUMED")
    private LocalDate dateConsumed;

}