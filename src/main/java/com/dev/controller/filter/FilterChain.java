package com.dev.controller.filter;

import com.dev.appconfig.AppConfig;
import com.dev.model.Bike;
import com.dev.service.BikeService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FilterChain {
    private static List<Bike> bikes;

    public static List<Bike> startFilter(String input) {
        getInitialBikesList();
        int numBeforeSearch = bikes.size();
        filterByBrand(parseParameters(input));
        if (numBeforeSearch == bikes.size()) {
            return new ArrayList<>();
        }
        return bikes;
    }

    private static void filterByBrand(List<String> parametersList) {
        String[] brandSearch;
        for (String string : parametersList) {
            if (string.contains("brand")) {
                brandSearch = string.split(": ");
                if (brandSearch.length != 2) {
                    System.out.println("\nInvalid brand search input\n");
                    return;
                }
                String[] finalBrandSearch = brandSearch;
                bikes = bikes.stream()
                        .filter(b -> b.getBrand().contains(finalBrandSearch[1]))
                        .collect(Collectors.toList());
                break;
            }
        }
        filterByPrice(parametersList);
    }

    private static void filterByPrice(List<String> parametersList) {
        String[] priceSearch;
        for (String string : parametersList) {
            if (string.contains("price")) {
                priceSearch = string.split(": ");
                if (priceSearch.length != 2 || Integer.parseInt(priceSearch[1]) <= 0) {
                    System.out.println("\nInvalid price search input\n");
                    return;
                }
                String[] finalPriceSearch = priceSearch;
                bikes = bikes.stream()
                        .filter(b -> b.getPrice() == Integer.parseInt(finalPriceSearch[1]))
                        .collect(Collectors.toList());
                break;
            }
        }
        filterByWeight(parametersList);
    }

    private static void filterByWeight(List<String> parametersList) {
        String[] weightSearch;
        for (String string : parametersList) {
            if (string.contains("weight")) {
                weightSearch = string.split(": ");
                if (weightSearch.length != 2 || Integer.parseInt(weightSearch[1]) <= 0) {
                    System.out.println("\nInvalid weight search input\n");
                    return;
                }
                String[] finalWeightSearch = weightSearch;
                bikes = bikes.stream()
                        .filter(b -> b.getWeight() == Integer.parseInt(finalWeightSearch[1]))
                        .collect(Collectors.toList());
                break;
            }
        }
        filterByColor(parametersList);
    }

    private static void filterByColor(List<String> parametersList) {
        String[] colorSearch;
        for (String string : parametersList) {
            if (string.contains("color")) {
                colorSearch = string.split(": ");
                if (colorSearch.length != 2) {
                    System.out.println("\nInvalid color search input\n");
                    return;
                }
                String[] finalColorSearch = colorSearch;
                bikes = bikes.stream()
                        .filter(b -> b.getColor().contains(finalColorSearch[1]))
                        .collect(Collectors.toList());
                break;
            }
        }
        filterByLightsAvailable(parametersList);
    }

    private static void filterByLightsAvailable(List<String> parametersList) {
        String[] lightsSearch;
        for (String string : parametersList) {
            if (string.contains("lights")) {
                lightsSearch = string.split(": ");
                if (lightsSearch.length != 2) {
                    System.out.println("\nInvalid lights search input\n");
                    return;
                }
                String[] finalLightsSearch = lightsSearch;
                bikes = bikes.stream()
                        .filter(b -> b.isLightsAvailable()
                                == Boolean.parseBoolean(finalLightsSearch[1]))
                        .collect(Collectors.toList());
                break;
            }
        }
    }

    private static List<String> parseParameters(String input) {
        return Arrays
                .stream(input.split(", "))
                .collect(Collectors.toList());
    }

    private static void getInitialBikesList() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        BikeService bikeService = context.getBean(BikeService.class);
        bikes = bikeService.getAll();
    }
}
