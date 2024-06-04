package org.example.hospitalstocks.services;

import org.example.hospitalstocks.models.Offer;
import org.example.hospitalstocks.models.Purchase;
import org.example.hospitalstocks.repositories.PurchaseRepository;
import org.example.hospitalstocks.responsebodies.PurchaseResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    /**
     * Retrieves a list of all the purchases made
     * @return the list of purchase response bodies
     */
    public List<PurchaseResponseBody> getAllPurchases() {
        List<Purchase> purchases = purchaseRepository.findAll();
        List<PurchaseResponseBody> purchaseResponseBodies = new ArrayList<>();
        for (Purchase purchase : purchases) {
            purchaseResponseBodies.add(new PurchaseResponseBody(purchase));
        }
        return purchaseResponseBodies;
    }

    /**
     * Retrieves a list of purchases in normal form (non-response body form)
     * @return the list of purchases
     */
    public List<Purchase> getNormalPurchases() {
        return purchaseRepository.findAll();
    }

    /**
     * Adds a purchase to the database
     * @param purchase the purchase to be added
     */
    public void add(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    /**
     * Creates a Purchase instance from an offer
     * @param offer the offer to be used
     */
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
