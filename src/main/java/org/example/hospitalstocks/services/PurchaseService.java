package org.example.hospitalstocks.services;

import org.example.hospitalstocks.models.Offer;
import org.example.hospitalstocks.models.Purchase;
import org.example.hospitalstocks.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public void add(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    public void createFromOffer(Offer offer) {
        Purchase purchase = new Purchase();
        purchase.setId(UUID.randomUUID().toString());
        purchase.setDrug(offer.getDrug());
        purchase.setQuantity(offer.getQuantity());
        purchase.setPrice(offer.getPrice());
        purchase.setDateBought(LocalDate.now());
        purchaseRepository.save(purchase);
    }
}
