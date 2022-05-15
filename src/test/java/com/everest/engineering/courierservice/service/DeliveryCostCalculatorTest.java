package com.everest.engineering.courierservice.service;

import com.everest.engineering.courierservice.dto.DeliveryCostInput;
import com.everest.engineering.courierservice.dto.DeliveryCostOutput;
import com.everest.engineering.courierservice.dto.Offer;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeliveryCostCalculatorTest {

    @Test
    public void calculateDeliveryCost_whenDiscountIsNotApplicable() {

        Offer offer = new Offer();
        offer.setMinDistance(30.0);
        offer.setMaxDistance(50.0);
        offer.setMinWeight(15.0);
        offer.setMaxWeight(40.0);
        offer.setDiscountPercent(10.0);

        DeliveryCostInput deliveryCostInput = new DeliveryCostInput();
        deliveryCostInput.setOffer(offer);
        deliveryCostInput.setDistanceInKm(10.0);
        deliveryCostInput.setPackageWeightInKg(30.0);

        assertFalse(deliveryCostInput.isOfferApplicable());

        DeliveryCostOutput deliveryCostOutput = new DeliveryCostCalculator().calculateDeliveryCost(deliveryCostInput, 100.0);

        assertEquals(0.0, deliveryCostOutput.getDiscount(), 0);
        assertEquals(450.0, deliveryCostOutput.getTotalCost(), 0);

    }

    @Test
    public void calculateDeliveryCost_whenDiscountIsApplicable() {

        Offer offer = new Offer();
        offer.setMinDistance(5.0);
        offer.setMaxDistance(50.0);
        offer.setMinWeight(15.0);
        offer.setMaxWeight(40.0);
        offer.setDiscountPercent(10.0);

        DeliveryCostInput deliveryCostInput = new DeliveryCostInput();
        deliveryCostInput.setOffer(offer);
        deliveryCostInput.setDistanceInKm(10.0);
        deliveryCostInput.setPackageWeightInKg(30.0);

        assertTrue(deliveryCostInput.isOfferApplicable());

        DeliveryCostOutput deliveryCostOutput = new DeliveryCostCalculator().calculateDeliveryCost(deliveryCostInput, 100.0);

        assertEquals(45.0, deliveryCostOutput.getDiscount(), 0);
        assertEquals(405.0, deliveryCostOutput.getTotalCost(), 0);

    }


}