package com.everest.engineering.courierservice.service;

import com.everest.engineering.courierservice.dto.Input;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertEquals;

public class DeliveryTimeCalculatorTest {

    @Test
    public void calculateDeliveryCostAndTime() throws Exception {
        URL resource = DeliveryTimeCalculatorTest.class.getResource("/delivery_cost_and_time_input.txt");
        Input input = new InputExtractor().extractInput(resource.openStream());
        new DeliveryTimeCalculator().calculateDeliveryCostAndTime(input);

        assertEquals(0.0, input.getDeliveryCostInputs().get(0).getDeliveryCostOutput().getDiscount(), 1);
        assertEquals(750.0, input.getDeliveryCostInputs().get(0).getDeliveryCostOutput().getTotalCost(), 1);
        assertEquals(3.98, input.getDeliveryCostInputs().get(0).getDeliveryCostOutput().getEstimatedDeliveryTimeInHours(), 1);

        assertEquals(0.0, input.getDeliveryCostInputs().get(1).getDeliveryCostOutput().getDiscount(), 1);
        assertEquals(1475.0, input.getDeliveryCostInputs().get(1).getDeliveryCostOutput().getTotalCost(), 1);
        assertEquals(1.78, input.getDeliveryCostInputs().get(1).getDeliveryCostOutput().getEstimatedDeliveryTimeInHours(), 1);

        assertEquals(0.0, input.getDeliveryCostInputs().get(2).getDeliveryCostOutput().getDiscount(), 1);
        assertEquals(2350.0, input.getDeliveryCostInputs().get(2).getDeliveryCostOutput().getTotalCost(), 1);
        assertEquals(1.42, input.getDeliveryCostInputs().get(2).getDeliveryCostOutput().getEstimatedDeliveryTimeInHours(), 1);

        assertEquals(105.0, input.getDeliveryCostInputs().get(3).getDeliveryCostOutput().getDiscount(), 1);
        assertEquals(1395.0, input.getDeliveryCostInputs().get(3).getDeliveryCostOutput().getTotalCost(), 1);
        assertEquals(0.85, input.getDeliveryCostInputs().get(3).getDeliveryCostOutput().getEstimatedDeliveryTimeInHours(), 1);

        assertEquals(0.0, input.getDeliveryCostInputs().get(4).getDeliveryCostOutput().getDiscount(), 1);
        assertEquals(2125.0, input.getDeliveryCostInputs().get(4).getDeliveryCostOutput().getTotalCost(), 1);
        assertEquals(4.19, input.getDeliveryCostInputs().get(4).getDeliveryCostOutput().getEstimatedDeliveryTimeInHours(), 1);

    }

}