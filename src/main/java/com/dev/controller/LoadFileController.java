package com.dev.controller;

import com.dev.appconfig.AppConfig;
import com.dev.model.Bike;
import com.dev.model.ElectricBike;
import com.dev.model.FoldingBike;
import com.dev.model.Speedelec;
import com.dev.service.BikeService;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LoadFileController {
    public static void loadFile(String filePath) {
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }
        scanner.useDelimiter("/n");
        List<Bike> bikes = new ArrayList<>();
        while (scanner.hasNextLine()) {
            bikes.add(parseBikeObject(scanner.nextLine()));
        }
        loadFileToStorage(bikes);
    }

    private static void loadFileToStorage(List<Bike> bikes) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        BikeService bikeService = context.getBean(BikeService.class);
        bikeService.addBikeList(bikes);
    }

    private static Bike parseBikeObject(String input) {
        String[] parseParameters = input.split("; ");
        if (parseParameters[0].contains("SPEEDELEC")) {
            return parseSpeedelecBike(parseParameters);
        } else if (parseParameters[0].contains("E-BIKE")) {
            return parseElectricBike(parseParameters);
        } else {
            return parseFoldingBike(parseParameters);
        }
    }

    private static Bike parseFoldingBike(String[] parseParameters) {
        return new FoldingBike(true,
                parseParameters[0],
                Integer.parseInt(parseParameters[3]),
                Integer.parseInt(parseParameters[6]),
                Boolean.parseBoolean(parseParameters[4]),
                parseParameters[5],
                Integer.parseInt(parseParameters[1]),
                Integer.parseInt(parseParameters[2])
                );
    }

    private static Bike parseSpeedelecBike(String[] parseParameters) {
        return new Speedelec(true,
                parseParameters[0],
                Integer.parseInt(parseParameters[2]),
                Integer.parseInt(parseParameters[6]),
                Boolean.parseBoolean(parseParameters[3]),
                parseParameters[5],
                Integer.parseInt(parseParameters[1]),
                Integer.parseInt(parseParameters[4])
        );
    }

    private static Bike parseElectricBike(String[] parseParameters) {
        return new ElectricBike(true,
                parseParameters[0],
                Integer.parseInt(parseParameters[2]),
                Integer.parseInt(parseParameters[6]),
                Boolean.parseBoolean(parseParameters[3]),
                parseParameters[5],
                Integer.parseInt(parseParameters[1]),
                Integer.parseInt(parseParameters[4])
        );
    }
}
