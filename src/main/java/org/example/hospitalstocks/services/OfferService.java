package org.example.hospitalstocks.services;

import org.example.hospitalstocks.models.Offer;
import org.example.hospitalstocks.models.Purchase;
import org.example.hospitalstocks.models.StockEntry;
import org.example.hospitalstocks.repositories.OfferRepository;
import org.example.hospitalstocks.requestbodies.OfferRequestBody;
import org.example.hospitalstocks.responsebodies.OfferResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OfferService {
    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private StockEntryService stockEntryService;

    /**
     * Returns all the available offers
     * @return a list containing all the offers
     */
    public List<OfferResponseBody> getAllOffers() {
        List<OfferResponseBody> offers = new ArrayList<>();
        for (Offer offer : offerRepository.findAll()) {
            offers.add(new OfferResponseBody(offer));
        }
        return offers;
    }

    /**
     * Initiates the purchase of an offer
     * @param id the id of the offer in question
     */
    public void buyOffer(String id) {
        Optional<Offer> optionalOffer = offerRepository.findById(id);
        if (optionalOffer.isPresent()) {
            Offer offer = optionalOffer.get();
            purchaseService.createFromOffer(offer);
            stockEntryService.createStockEntryFromOffer(offer);
            deleteOffer(offer.getId());
        }
    }

    public Offer getOfferById(String id) {
        Optional<Offer> offer = offerRepository.findById(id);
        return offer.orElse(null);
    }

    public void addOffer(Offer offer) {
        offerRepository.save(offer);
    }

    /**
     * Deletes an offer from the database
     * @param id the id of the offer to be deleted
     */
    public void deleteOffer(String id) {
        offerRepository.deleteById(id);
    }

}
