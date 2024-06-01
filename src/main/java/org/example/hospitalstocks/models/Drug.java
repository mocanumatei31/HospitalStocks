package org.example.hospitalstocks.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "DRUG")
public class Drug {
    @Id
    @Size(max = 40)
    @Column(name = "ID", nullable = false, length = 40)
    private String id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID", nullable = false)
    private Manufacturer manufacturer;

    @Size(max = 50)
    @NotNull
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Size(max = 100)
    @Column(name = "DESCRIPTION", length = 100)
    private String description;

    @Size(max = 50)
    @Column(name = "CATEGORY", length = 50)
    private String category;

    @Size(max = 50)
    @Column(name = "DOSAGE", length = 50)
    private String dosage;

    @Size(max = 50)
    @Column(name = "TYPE", length = 50)
    private String type;

    @Size(max = 40)
    @Column(name = "MANUFACTURER_ID", length = 40)
    private String manufacturerId;

    @OneToMany(mappedBy = "drug")
    private Set<Offer> offers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "drug")
    private Set<StockEntry> stockEntries = new LinkedHashSet<>();

}