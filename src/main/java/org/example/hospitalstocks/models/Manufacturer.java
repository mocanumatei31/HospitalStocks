package org.example.hospitalstocks.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "MANUFACTURER")
public class Manufacturer {
    @Id
    @Size(max = 50)
    @Column(name = "ID", nullable = false, length = 50)
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

    @OneToMany(mappedBy = "manufacturer")
    private Set<Drug> drugs = new LinkedHashSet<>();

    @Override
    public String toString() {
        List<String> names = new ArrayList<>();
        for(Drug d : drugs){
            names.add(d.getName());
        }
        return "Manufacturer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", drugs=" + names +
                '}';
    }
}