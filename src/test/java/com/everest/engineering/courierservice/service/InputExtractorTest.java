package com.everest.engineering.courierservice.service;

import com.everest.engineering.courierservice.dto.Input;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.*;

public class InputExtractorTest {

    @Test
    public void extractInput_whenInputIsGiven_returnInput() throws Exception {

        URL resource = InputExtractorTest.class.getResource("/delivery_cost_input.txt");

        Input input = new InputExtractor().extractInput(resource.openStream());
        assertNotNull(input);

        assertEquals(100.0, input.getBaseDeliveryCost(), 0);
        assertNotNull(input.getDeliveryCostInputs());
        assertEquals(3,input.getDeliveryCostInputs().size());

        assertEquals("PKG1", input.getDeliveryCostInputs().get(0).getPackageId());
        assertEquals(5.0, input.getDeliveryCostInputs().get(0).getPackageWeightInKg(), 0);
        assertEquals(5.0, input.getDeliveryCostInputs().get(0).getDistanceInKm(), 0);
        assertNotNull(input.getDeliveryCostInputs().get(0).getOffer());
        assertEquals("OFR001", input.getDeliveryCostInputs().get(0).getOffer().getName());

        assertEquals("PKG2", input.getDeliveryCostInputs().get(1).getPackageId());
        assertEquals(15.0, input.getDeliveryCostInputs().get(1).getPackageWeightInKg(), 0);
        assertEquals(5.0, input.getDeliveryCostInputs().get(1).getDistanceInKm(), 0);
        assertNotNull(input.getDeliveryCostInputs().get(1).getOffer());
        assertEquals("OFR002", input.getDeliveryCostInputs().get(1).getOffer().getName());

        assertEquals("PKG3", input.getDeliveryCostInputs().get(2).getPackageId());
        assertEquals(10.0, input.getDeliveryCostInputs().get(2).getPackageWeightInKg(), 0);
        assertEquals(100.0, input.getDeliveryCostInputs().get(2).getDistanceInKm(), 0);
        // Offer is not applicable
        assertNull(input.getDeliveryCostInputs().get(2).getOffer());

        assertEquals(2, input.getNoOfVehicles().intValue());
        assertEquals(70.0, input.getMaxSpeed(),0);
        assertEquals(200.0, input.getMaxCarriableWeight(),0);

    }

}