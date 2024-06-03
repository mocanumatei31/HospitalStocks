package org.example.hospitalstocks.controllers;

import org.example.hospitalstocks.requestbodies.OfferRequestBody;
import org.example.hospitalstocks.responsebodies.OfferResponseBody;
import org.example.hospitalstocks.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
public class OfferController {
    @Autowired
    private OfferService offerService;
    @GetMapping("/offers")
    public List<OfferResponseBody> getAllOffers(){
        return offerService.getAllOffers();
    }

    @PostMapping("/offers/buy")
    public void buyOffer(@RequestBody String id){
        id = id.replace("\"", "");
        offerService.buyOffer(id);
    }
}
