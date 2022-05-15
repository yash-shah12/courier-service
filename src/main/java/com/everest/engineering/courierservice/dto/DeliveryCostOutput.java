package com.everest.engineering.courierservice.dto;

import lombok.Data;

@Data
public class DeliveryCostOutput {

    private Double discount;
    private Double totalCost;
    private Double estimatedDeliveryTimeInHours;

}
