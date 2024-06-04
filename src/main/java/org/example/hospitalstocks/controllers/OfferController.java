package org.example.hospitalstocks.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.hospitalstocks.requestbodies.OfferRequestBody;
import org.example.hospitalstocks.responsebodies.OfferResponseBody;
import org.example.hospitalstocks.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Offers Controller", description = "Management of the Data regarding Offers provided to the Hospital")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
public class OfferController {
    @Autowired
    private OfferService offerService;
    @Operation(summary = "Retrieves all the Active Offers", description = "Returns a list of all the offers that are currently active")
    @GetMapping("/offers")
    public List<OfferResponseBody> getAllOffers(){
        return offerService.getAllOffers();
    }

    @Operation(summary = "purchases an Offer", description = "Receives the Id of the Offer to be purchased in the Request Body," +
            " then goes through with the purchase of said offer, removing it from the Offers and adding the bought stock to StockEntries " +
            "and the Data regarding the Purchase to Purchases")
    @PostMapping("/offers/buy")
    public void buyOffer(@RequestBody String id){
        id = id.replace("\"", "");
        offerService.buyOffer(id);
    }
}
