package com.everest.engineering.courierservice.manager;

import org.junit.Test;

import static org.junit.Assert.*;

public class OfferManagerTest {

    @Test
    public void getOffer_whenOfferIsValid_returnOffer() {
        assertNotNull(OfferManager.getOffer("OFR001"));
        assertEquals("OFR001",OfferManager.getOffer("OFR001").getName());
    }

    @Test
    public void getOffer_whenOfferIsNotValid_returnNull() {
        assertNull(OfferManager.getOffer("OFR"));
    }
}