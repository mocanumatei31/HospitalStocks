package org.example.hospitalstocks.responsebodies;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.hospitalstocks.models.Drug;
import org.example.hospitalstocks.models.Manufacturer;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
public class DrugResponseBody {
    private String id;
    private String name;
    private String description;
    private String category;
    private String dosage;
    private String type;
    private String manufacturerName;
    public DrugResponseBody(Drug drug){
        this.id = drug.getId();
        this.name = drug.getName();
        this.description = drug.getDescription();
        this.category = drug.getCategory();
        this.dosage = drug.getDosage();
        this.type = drug.getType();
        this.manufacturerName = drug.getManufacturer().getName();
    }
}
