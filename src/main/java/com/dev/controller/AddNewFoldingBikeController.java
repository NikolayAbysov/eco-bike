package com.dev.controller;

import com.dev.appconfig.AppConfig;
import com.dev.model.Bike;
import com.dev.model.FoldingBike;
import com.dev.service.BikeService;
import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AddNewFoldingBikeController {
    static void addNewFoldingBike() {
        Scanner scanner = new Scanner(System.in);
        FoldingBike bike = new FoldingBike();
        String input;

        System.out.println("Please, enter model name: \n");
        while (true) {
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                bike.setBrand("FOLDING BIKE " + input);
                break;
            } else {
                System.out.println("Please, provide model name!");
            }
        }

        System.out.println("Please, enter wheel size: \n");
        while (true) {
            input = scanner.nextLine();
            if (!input.isEmpty() && input.matches("^[1-9]\\d*$")) {
                bike.setWheelSize(Integer.parseInt(input));
                break;
            } else {
                System.out.println("Please, provide correct wheel size!");
            }
        }

        System.out.println("Please, enter number of gears: \n");
        while (true) {
            input = scanner.nextLine();
            if (!input.isEmpty() && input.matches("^[1-9]\\d*$")) {
                bike.setGearsNumber(Integer.parseInt(input));
                break;
            } else {
                System.out.println("Please, provide correct gears number!");
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
