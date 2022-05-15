package com.everest.engineering.courierservice.dto;

import lombok.Data;

@Data
public class DeliveryCostInput {

    private String packageId;
    private Double packageWeightInKg;
    private Double distanceInKm;
    private Offer offer;
    private boolean isDelivered;
    private DeliveryCostOutput deliveryCostOutput;

    public boolean isOfferApplicable() {
        return validateNull() && validateDistanceInRange() && validateWeightInRange();
    }

    private boolean validateNull(){
        return offer != null && offer.getMinDistance() != null && offer.getMaxDistance() != null
                && offer.getMinWeight() != null && offer.getMaxWeight() != null;
    }

    private boolean validateDistanceInRange(){
        return distanceInKm >= offer.getMinDistance() && distanceInKm <= offer.getMaxDistance();
    }

    private boolean validateWeightInRange(){
        return packageWeightInKg >= offer.getMinWeight() && packageWeightInKg <= offer.getMaxWeight();
    }


}
