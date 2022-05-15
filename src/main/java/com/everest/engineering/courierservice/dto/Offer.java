package com.everest.engineering.courierservice.dto;

import lombok.Data;

@Data
public class Offer {

    private String name;
    private Double discountPercent;
    private Double minDistance;
    private Double maxDistance;
    private Double minWeight;
    private Double maxWeight;

}
