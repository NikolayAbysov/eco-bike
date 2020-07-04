package com.dev.controller.filter;

import com.dev.appconfig.AppConfig;
import com.dev.model.FoldingBike;
import com.dev.model.Speedelec;
import com.dev.service.BikeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

class FilterChainTest {
    private static Speedelec speedelec;
    private static FoldingBike foldingBike;
    private static BikeService bikeService;

    @BeforeEach
    void init() {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        bikeService = context.getBean(BikeService.class);

        speedelec = new Speedelec();
        speedelec.setBatteryCapacity(12500);
        speedelec.setMaxSpeed(23);
        speedelec.setBrand("SPEEDELEC EcoRide");
        speedelec.setColor("red");
        speedelec.setLightsAvailable(false);
        speedelec.setWeight(11000);
        speedelec.setPrice(1000);

        foldingBike = new FoldingBike();
        foldingBike.setWheelSize(24);
        foldingBike.setGearsNumber(10);
        foldingBike.setBrand("FOLDING BIKE Cibo");
        foldingBike.setColor("green");
        foldingBike.setLightsAvailable(false);
        foldingBike.setWeight(13000);
        foldingBike.setPrice(1000);
    }

    @Test
    void addBikeServiceOk() {
        bikeService.add(speedelec);
        bikeService.add(foldingBike);
        assertEquals(FilterChain.startFilter("brand: FOLDING BIKE, color: green").get(0),
                foldingBike, "Folding bike should be found");
        assertEquals(FilterChain.startFilter("brand: EcoRide, price: 1000").get(0),
                speedelec, "Speedelec bike should be found");
        assertEquals(FilterChain.startFilter("price: 1000").size(), 2,
                "Both folding and speedelec bikes should be found");
    }

}