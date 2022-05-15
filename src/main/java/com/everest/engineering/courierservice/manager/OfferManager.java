package com.everest.engineering.courierservice.manager;

import com.everest.engineering.courierservice.dto.Offer;

import java.util.HashMap;

public final class OfferManager {

    private static final HashMap<String, Offer> validOffersMap = new HashMap<>();

    private OfferManager() {
    }

    static {

        Offer offer = new Offer();
        offer.setName("OFR001");
        offer.setDiscountPercent(10.0);
        offer.setMinDistance(0.0);
        offer.setMaxDistance(200.0);
        offer.setMinWeight(70.0);
        offer.setMaxWeight(200.0);
        validOffersMap.put(offer.getName(), offer);

        offer = new Offer();
        offer.setName("OFR002");
        offer.setDiscountPercent(7.0);
        offer.setMinDistance(50.0);
        offer.setMaxDistance(150.0);
        offer.setMinWeight(100.0);
        offer.setMaxWeight(250.0);
        validOffersMap.put(offer.getName(), offer);

        offer = new Offer();
        offer.setName("OFR003");
        offer.setDiscountPercent(5.0);
        offer.setMinDistance(50.0);
        offer.setMaxDistance(250.0);
        offer.setMinWeight(10.0);
        offer.setMaxWeight(150.0);
        validOffersMap.put(offer.getName(), offer);

    }

    public static Offer getOffer(String offerName) {
        return validOffersMap.get(offerName);
    }

}
