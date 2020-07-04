package com.dev.controller;

import com.dev.appconfig.AppConfig;
import com.dev.model.Bike;
import com.dev.model.ElectricBike;
import com.dev.model.FoldingBike;
import com.dev.model.Speedelec;
import com.dev.service.BikeService;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ShowCatalogController {
    static void showCatalog() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        BikeService bikeService = context.getBean(BikeService.class);
        List<Bike> bikes = bikeService.getAll();
        print(bikes);
    }

    static void print(List<Bike> bikes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Bike bike : bikes) {
            stringBuilder.append(bike.getBrand())
                    .append(" with ")
                    .append(getSpecificParameter(bike))
                    .append(" and ")
                    .append(getHeadlightParameter(bike))
                    .append("\n Price: ")
                    .append(bike.getPrice())
                    .append(" euros. \n \n");
        }
        System.out.println(stringBuilder.toString());
    }

    private static String getSpecificParameter(Bike bike) {
        StringBuilder stringBuilder = new StringBuilder();
        if (bike instanceof ElectricBike) {
            stringBuilder.append(((ElectricBike) bike).getBatteryCapacity())
                    .append(" mAh battery");
            return stringBuilder.toString();
        } else if (bike instanceof Speedelec) {
            stringBuilder.append(((Speedelec) bike).getBatteryCapacity())
                    .append(" mAh battery");
            return stringBuilder.toString();
        } else {
            stringBuilder.append(((FoldingBike) bike).getGearsNumber())
                    .append(" gear(s)");
            return stringBuilder.toString();
        }
    }

    private static String getHeadlightParameter(Bike bike) {
        return bike.isLightsAvailable() ? "head/tail light." : "no head/tail light.";
    }
}
