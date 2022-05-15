package com.everest.engineering.courierservice.service;

import com.everest.engineering.courierservice.dto.DeliveryCostInput;
import com.everest.engineering.courierservice.dto.Input;
import com.everest.engineering.courierservice.manager.OfferManager;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputExtractor {

    private DeliveryCostInput populateDeliveryCostInput(String data) {

        String[] inputs = data.split(" ");
        DeliveryCostInput deliveryCostInput = new DeliveryCostInput();
        deliveryCostInput.setPackageId(inputs[0]);
        deliveryCostInput.setPackageWeightInKg(Double.parseDouble(inputs[1]));
        deliveryCostInput.setDistanceInKm(Double.parseDouble(inputs[2]));
        deliveryCostInput.setOffer(OfferManager.getOffer(inputs[3]));
        return deliveryCostInput;
    }

    public Input extractInput(InputStream inputStream) {

        Scanner scanner = new Scanner(inputStream);
        String[] line1Inputs = scanner.nextLine().split(" ");
        Double baseDeliveryCost = Double.parseDouble(line1Inputs[0]);
        int noOfPackages = Integer.parseInt(line1Inputs[1]);

        List<DeliveryCostInput> deliveryCostInputs = new ArrayList<>();
        int i = 0;
        while (i < noOfPackages) {
            deliveryCostInputs.add(populateDeliveryCostInput(scanner.nextLine()));
            i++;
        }

        String lastLine = scanner.nextLine();
        String[] lastLineInputs = lastLine.split(" ");

        Input input = new Input();
        input.setBaseDeliveryCost(baseDeliveryCost);
        input.setDeliveryCostInputs(deliveryCostInputs);
        input.setNoOfVehicles(Integer.parseInt(lastLineInputs[0]));
        input.setMaxSpeed(Double.parseDouble(lastLineInputs[1]));
        input.setMaxCarriableWeight(Double.parseDouble(lastLineInputs[2]));
        return input;
    }

}
