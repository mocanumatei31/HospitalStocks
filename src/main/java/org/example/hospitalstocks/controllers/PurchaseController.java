package org.example.hospitalstocks.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.example.hospitalstocks.models.Drug;
import org.example.hospitalstocks.responsebodies.PurchaseResponseBody;
import org.example.hospitalstocks.services.PurchaseService;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Tag(name = "Purchases Controller", description = "Management of the Data regarding Purchases made by the Hospital")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @Operation(summary = "Retrieves all Purchases made by the Hospital",
                description = "Returns a List of Purchases made by the Hospital")
    @GetMapping("/purchases")
    public List<PurchaseResponseBody> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }
}
