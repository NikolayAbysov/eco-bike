package com.dev.controller;

import com.dev.appconfig.AppConfig;
import com.dev.model.Bike;
import com.dev.model.Speedelec;
import com.dev.service.BikeService;
import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AddNewSpeedelecBikeController {
    static void addNewSpeedelecBike() {
        Scanner scanner = new Scanner(System.in);
        Speedelec bike = new Speedelec();
        String input;

        System.out.println("Please, enter model name: \n");
        while (true) {
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                bike.setBrand("SPEEDELEC " + input);
                break;
            } else {
                System.out.println("Please, provide model name!");
            }
        }

        System.out.println("Please, enter weight of bike: \n");
        while (true) {
            input = scanner.nextLine();
            if (!input.isEmpty() && input.matches("^[1-9]\\d*$")) {
                bike.setWeight(Integer.parseInt(input));
                break;
            } else {
                System.out.println("Please, provide correct weight!");
            }
        }

        System.out.println("Please, enter the availability "
                + "of lights at front and back (true/false input required): \n");
        while (true) {
            input = scanner.nextLine();
            if (!input.isEmpty() && (input.contains("true") || input.contains("false"))) {
                bike.setLightsAvailable(Boolean.parseBoolean(input));
                break;
            } else {
                System.out.println("Please, provide correct value "
                        + "(true/false input required) of lights availability!");
            }
        }

        System.out.println("Please, enter color: \n");
        while (true) {
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                bike.setColor(input);
                break;
            } else {
                System.out.println("Please, provide correct color name!");
            }
        }

        System.out.println("Please, enter price: \n");
        while (true) {
            input = scanner.nextLine();
            if (!input.isEmpty() && input.matches("^[1-9]\\d*$")) {
                bike.setPrice(Integer.parseInt(input));
                break;
            } else {
                System.out.println("Please, provide correct price value!");
            }
        }

        System.out.println("Please, enter max speed: \n");
        while (true) {
            input = scanner.nextLine();
            if (!input.isEmpty() && input.matches("^[1-9]\\d*$")) {
                bike.setMaxSpeed(Integer.parseInt(input));
                break;
            } else {
                System.out.println("Please, provide correct max speed value!");
            }
        }

        System.out.println("Please, enter battery capacity: \n");
        while (true) {
            input = scanner.nextLine();
            if (!input.isEmpty() && input.matches("^[1-9]\\d*$")) {
                bike.setBatteryCapacity(Integer.parseInt(input));
                break;
            } else {
                System.out.println("Please, provide correct capacity value!");
            }
        }
        bike.setLoadedFromFile(false);
        writeToStorage(bike);
        System.out.println("Bike successfully added!\n");
    }

    private static void writeToStorage(Bike bike) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        BikeService bikeService = context.getBean(BikeService.class);
        bikeService.add(bike);
    }
}
