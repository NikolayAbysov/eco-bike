package com.dev.controller;

import com.dev.controller.filter.FilterChain;
import com.dev.model.Bike;
import java.util.List;
import java.util.Scanner;

class FindFirstItemParticularBrandController {
    static void find() {
        System.out.println("Please, type parameters [brand, weight, price, lights or color] "
                + "with values to find.");
        System.out.println("Example of input: brand: FOLDING BIKE, price: 1200");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Bike> bikes = FilterChain.startFilter(input);

        if (bikes.isEmpty()) {
            System.out.println("No matches for this search\n\n");
        } else {
            showFilterResults(bikes);
        }
    }

    private static void showFilterResults(List<Bike> bikes) {
        ShowCatalogController.print(bikes);
    }
}
