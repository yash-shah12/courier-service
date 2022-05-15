package com.everest.engineering.courierservice;

import com.everest.engineering.courierservice.dto.DeliveryCostInput;
import com.everest.engineering.courierservice.dto.Input;
import com.everest.engineering.courierservice.service.DeliveryTimeCalculator;
import com.everest.engineering.courierservice.service.InputExtractor;

public class App {

    public static void main(String[] args) {
        Input input = new InputExtractor().extractInput(System.in);
        DeliveryTimeCalculator deliveryTimeCalculator = new DeliveryTimeCalculator();
        deliveryTimeCalculator.calculateDeliveryCostAndTime(input);
        for (DeliveryCostInput deliveryCostInput : input.getDeliveryCostInputs()) {
            System.out.printf("%s %s %s %s%n", deliveryCostInput.getPackageId(), deliveryCostInput.getDeliveryCostOutput().getDiscount(), deliveryCostInput.getDeliveryCostOutput().getTotalCost(), deliveryCostInput.getDeliveryCostOutput().getEstimatedDeliveryTimeInHours());
        }
    }
}
