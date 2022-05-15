package com.everest.engineering.courierservice.util;

import java.util.ArrayList;
import java.util.List;

public final class MathUtil {

    private MathUtil() {
    }

    private static Double knapsack(Double w, List<Double> wt, List<Double> val, int n) {
        if (n == 0 || w == 0.0) return 0.0;

        if (wt.get(n - 1) > w) {
            return knapsack(w, wt, val, n - 1);
        } else {
            return Math.max(val.get(n - 1) + knapsack(w - wt.get(n - 1), wt, val, n - 1), knapsack(w, wt, val, n - 1));
        }

    }

    private static void findElementsEqualToGivenSum(List<Double> input, int n, List<Double> temp, Double sum, List<Double> result) {
        if (sum == 0) {
            result.addAll(temp);
            return;
        }

        if (n == 0) return;

        findElementsEqualToGivenSum(input, n - 1, temp, sum, result);
        List<Double> v1 = new ArrayList<>(temp);
        v1.add(input.get(n - 1));
        findElementsEqualToGivenSum(input, n - 1, v1, sum - input.get(n - 1), result);
    }

    public static Double maxSumLessEqualToThenGivenSumInList(Double k, List<Double> input) {
        return knapsack(k, input, input, input.size());
    }

    public static List<Double> findAndGetElementsEqualToGivenSum(List<Double> input, Double sum) {
        List<Double> result = new ArrayList<>();
        findElementsEqualToGivenSum(input, input.size(), new ArrayList<>(), sum, result);
        return result;
    }

    public static double round(double value) {
        String valueString = String.valueOf(value);
        if (valueString.length() - 1 - valueString.indexOf(".") < 2) return value;
        return Double.parseDouble(valueString.substring(0, valueString.indexOf(".") + 3));
    }
}
