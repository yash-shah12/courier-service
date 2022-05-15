package com.everest.engineering.courierservice.dto;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeliveryCostInputTest {

    @Test
    public void isOfferApplicable_whenOfferIsNull_thenReturnFalse() {
        DeliveryCostInput deliveryCostInput = new DeliveryCostInput();
        assertFalse(deliveryCostInput.isOfferApplicable());
    }

    @Test
    public void isOfferApplicable_whenAnyOfferConditionsIsNull_thenReturnFalse() {
        DeliveryCostInput deliveryCostInput = new DeliveryCostInput();
        deliveryCostInput.setDistanceInKm(25.0);
        deliveryCostInput.setPackageWeightInKg(50.0);

        Offer offer = new Offer();
        deliveryCostInput.setOffer(offer);

        // All conditions is null
        assertFalse(deliveryCostInput.isOfferApplicable());

        offer.setMinDistance(3.0);
        offer.setMaxDistance(5.0);
        offer.setMinWeight(3.0);
        offer.setMaxWeight(null);
        assertFalse(deliveryCostInput.isOfferApplicable());

        offer.setMinDistance(3.0);
        offer.setMaxDistance(5.0);
        offer.setMinWeight(null);
        offer.setMaxWeight(10.0);
        assertFalse(deliveryCostInput.isOfferApplicable());

        offer.setMinDistance(3.0);
        offer.setMaxDistance(null);
        offer.setMinWeight(3.0);
        offer.setMaxWeight(10.0);
        assertFalse(deliveryCostInput.isOfferApplicable());

        offer.setMinDistance(null);
        offer.setMaxDistance(5.0);
        offer.setMinWeight(3.0);
        offer.setMaxWeight(12.0);
        assertFalse(deliveryCostInput.isOfferApplicable());
    }

    @Test
    public void isOfferApplicable_whenAnyOfferConditionsDoesntMatch_thenReturnFalse() {

        Offer offer = new Offer();
        offer.setMinDistance(15.0);
        offer.setMaxDistance(55.0);
        offer.setMinWeight(15.0);
        offer.setMaxWeight(24.0);

        DeliveryCostInput deliveryCostInput = new DeliveryCostInput();
        deliveryCostInput.setOffer(offer);

        // Distance is greater than max distance
        deliveryCostInput.setDistanceInKm(117.0);
        deliveryCostInput.setPackageWeightInKg(20.0);
        assertFalse(deliveryCostInput.isOfferApplicable());

        // Distance is less than min distance
        deliveryCostInput.setDistanceInKm(5.0);
        deliveryCostInput.setPackageWeightInKg(50.0);
        assertFalse(deliveryCostInput.isOfferApplicable());

        // Weight is greater than max weight
        deliveryCostInput.setDistanceInKm(17.0);
        deliveryCostInput.setPackageWeightInKg(50.0);
        assertFalse(deliveryCostInput.isOfferApplicable());

        // Weight is less than min weight
        deliveryCostInput.setDistanceInKm(5.0);
        deliveryCostInput.setPackageWeightInKg(3.0);
        assertFalse(deliveryCostInput.isOfferApplicable());

    }

    @Test
    public void isOfferApplicable_whenAllOfferConditionsMatch_thenReturnTrue() {

        Offer offer = new Offer();
        offer.setMinDistance(15.0);
        offer.setMaxDistance(55.0);
        offer.setMinWeight(15.0);
        offer.setMaxWeight(24.0);

        DeliveryCostInput deliveryCostInput = new DeliveryCostInput();
        deliveryCostInput.setOffer(offer);
        deliveryCostInput.setDistanceInKm(40.0);
        deliveryCostInput.setPackageWeightInKg(20.0);
        assertTrue(deliveryCostInput.isOfferApplicable());

    }
}