package com.everest.engineering.courierservice.service;

import com.everest.engineering.courierservice.dto.DeliveryCostInput;
import com.everest.engineering.courierservice.dto.DeliveryCostOutput;
import com.everest.engineering.courierservice.dto.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.everest.engineering.courierservice.util.MathUtil.*;

public class DeliveryTimeCalculator {

    private final DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator();

    public void calculateDeliveryCostAndTime(Input input) {

        ArrayList<Double> vehicleTime = new ArrayList<>();

        // Initializing vehicle time
        for (int i = 0; i < input.getNoOfVehicles(); i++) {
            vehicleTime.add(0.0);
        }

        int totalDelivered = 0;
        while (totalDelivered != input.getDeliveryCostInputs().size()) {
            List<Double> notDeliveredPackagesWeights = input.getDeliveryCostInputs().stream().filter(deliveryCostInput -> !deliveryCostInput.isDelivered()).map(DeliveryCostInput::getPackageWeightInKg).collect(Collectors.toList());
            List<Double> packagesWeightsToBeDeliveredInThisIteration = findAndGetElementsEqualToGivenSum(notDeliveredPackagesWeights, maxSumLessEqualToThenGivenSumInList(input.getMaxCarriableWeight(), notDeliveredPackagesWeights));
            final double[] maxDeliveryTime = {0};
            int minVehicleIndex = vehicleTime.indexOf(vehicleTime.stream().mapToDouble(Double::doubleValue).min().getAsDouble());
            for (Double weight : packagesWeightsToBeDeliveredInThisIteration) {
                input.getDeliveryCostInputs().stream().filter(deliveryCostInput -> !deliveryCostInput.isDelivered() && deliveryCostInput.getPackageWeightInKg().equals(weight)).findFirst().ifPresent(deliveryCostInput -> {
                    deliveryCostInput.setDelivered(true);
                    final double deliveryTime = round(deliveryCostInput.getDistanceInKm() / input.getMaxSpeed());
                    final double totalDeliveryTime = round(vehicleTime.get(minVehicleIndex) + deliveryTime);
                    DeliveryCostOutput deliveryCostOutput = deliveryCostCalculator.calculateDeliveryCost(deliveryCostInput, input.getBaseDeliveryCost());
                    deliveryCostOutput.setEstimatedDeliveryTimeInHours(totalDeliveryTime);
                    deliveryCostInput.setDeliveryCostOutput(deliveryCostOutput);

                    if (deliveryTime > maxDeliveryTime[0]) {
                        maxDeliveryTime[0] = deliveryTime;
                    }

                });
                totalDelivered++;
            }
            vehicleTime.set(minVehicleIndex, round(vehicleTime.get(minVehicleIndex) + maxDeliveryTime[0] * 2));
        }

    }


}
