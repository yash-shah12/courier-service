package com.everest.engineering.courierservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class Input {

    private Double baseDeliveryCost;
    private Integer noOfVehicles;
    private Double maxSpeed;
    private Double maxCarriableWeight;
    private List<DeliveryCostInput> deliveryCostInputs;

}
