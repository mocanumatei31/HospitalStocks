package org.example.hospitalstocks.responsebodies;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.hospitalstocks.models.Drug;
import org.example.hospitalstocks.models.Manufacturer;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
public class ManufacturerResponseBody {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String postalCode;
    private String city;
    private String country;
    private List<String> drugNames;
    public ManufacturerResponseBody(Manufacturer manufacturer) {
        this.id = manufacturer.getId();
        this.name = manufacturer.getName();
        this.email = manufacturer.getEmail();
        this.phoneNumber = manufacturer.getPhoneNumber();
        this.address = manufacturer.getAddress();
        this.postalCode = manufacturer.getPostalCode();
        this.city = manufacturer.getCity();
        this.country = manufacturer.getCountry();
        this.drugNames = new ArrayList<>();
        for(Drug d : manufacturer.getDrugs()) {
            drugNames.add(d.getName());
        }
    }
}
