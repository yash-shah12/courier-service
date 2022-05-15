package com.everest.engineering.courierservice.service;

import com.everest.engineering.courierservice.dto.DeliveryCostInput;
import com.everest.engineering.courierservice.dto.DeliveryCostOutput;

public class DeliveryCostCalculator {

    public DeliveryCostOutput calculateDeliveryCost(DeliveryCostInput deliveryCostInput, Double baseDeliveryCost) {

        final double deliveryCost = baseDeliveryCost + (deliveryCostInput.getPackageWeightInKg() * 10) + (deliveryCostInput.getDistanceInKm() * 5);
        final double discountPercent = deliveryCostInput.isOfferApplicable() ? deliveryCostInput.getOffer().getDiscountPercent() : 0;
        final double discount = deliveryCost * discountPercent / 100;
        final double totalCost = deliveryCost - discount;

        DeliveryCostOutput deliveryCostOutput = new DeliveryCostOutput();
        deliveryCostOutput.setDiscount(discount);
        deliveryCostOutput.setTotalCost(totalCost);

        return deliveryCostOutput;
    }

}
