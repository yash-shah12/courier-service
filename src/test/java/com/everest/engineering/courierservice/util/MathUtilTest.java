package com.everest.engineering.courierservice.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MathUtilTest {

    @Test
    public void maxSumLessEqualToThenGivenSumInList_mustReturnMaxPossibleSumLessThenOrEqualToK() {
        assertEquals(146.0, MathUtil.maxSumLessEqualToThenGivenSumInList(150.0, Arrays.asList(100.0, 80.0, 31.0, 40.0, 75.0)), 1);
        assertEquals(50.0, MathUtil.maxSumLessEqualToThenGivenSumInList(50.0, Arrays.asList(100.0, 20.0, 30.0, 40.0, 75.0)), 1);
    }

    @Test
    public void findAndGetElementsEqualToGivenSum() {
        List<Double> result = MathUtil.findAndGetElementsEqualToGivenSum(Arrays.asList(100.0, 80.0, 31.0, 40.0, 75.0), 146.0);
        assertTrue(result.containsAll(Arrays.asList(75.0, 31.0, 40.0)));
    }

    @Test
    public void round() {
        assertEquals(1.25,MathUtil.round(1.256),2);
        assertEquals(145.45,MathUtil.round(145.458215),2);
        assertEquals(1.27,MathUtil.round(1.2786),2);
        assertEquals(100.0,MathUtil.round(100.0),2);
        assertEquals(15.01,MathUtil.round(15.01),2);
    }

}