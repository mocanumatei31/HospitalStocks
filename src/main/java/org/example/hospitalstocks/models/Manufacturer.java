package org.example.hospitalstocks.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "MANUFACTURER")
public class Manufacturer {
    @Id
    @Size(max = 40)
    @Column(name = "ID", nullable = false, length = 40)
    private String id;

    @Size(max = 75)
    @NotNull
    @Column(name = "NAME", nullable = false, length = 75)
    private String name;

    @Size(max = 50)
    @Column(name = "EMAIL", length = 50)
    private String email;

    @Size(max = 50)
    @Column(name = "PHONE_NUMBER", length = 50)
    private String phoneNumber;

    @Size(max = 150)
    @Column(name = "ADDRESS", length = 150)
    private String address;

    @Size(max = 20)
    @Column(name = "POSTAL_CODE", length = 20)
    private String postalCode;

    @Size(max = 50)
    @Column(name = "CITY", length = 50)
    private String city;

    @Size(max = 50)
    @Column(name = "COUNTRY", length = 50)
    private String country;

    @OneToMany(mappedBy = "id")
    private Set<Drug> drug = new LinkedHashSet<>();

}