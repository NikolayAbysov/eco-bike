package com.dev.controller;

import java.util.Scanner;

public class MainMenuController {
    public static void getMainMenuController() {
        Scanner scanner = new Scanner(System.in);
        CommandController commandController = new CommandController();
        System.out.println("Please make your choice: \n"
                + "1 - Show the entire EcoBike catalog\n"
                + "2 – Add a new folding bike\n"
                + "3 – Add a new speedelec\n"
                + "4 – Add a new e-bike\n"
                + "5 – Find the first item of a particular brand\n"
                + "6 – Write to file\n"
                + "7 – Stop the program");

        switch (getCommand(scanner)) {
            case 1:
                commandController.showCatalog();
                break;
            case 2:
                commandController.addNewFoldingBike();
                break;
            case 3:
                commandController.addNewSpeedelecBike();
                break;
            case 4:
                commandController.addNewElectricBike();
                break;
            case 5:
                commandController.findFirstItemParticularBrand();
                break;
            case 6:
                commandController.writeToFile();
                break;
            case 7:
                commandController.stop();
                break;
            default:
                System.out.println("Please, choose correct variant\n");
                break;
        }
    }

    private static int getCommand(Scanner scanner) {
        String command = scanner.nextLine();
        if (command.matches("[1-7]")) {
            return Integer.parseInt(command);
        }
        return 0;
    }
}
