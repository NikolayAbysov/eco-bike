package com.dev.service.impl;

import com.dev.appconfig.AppConfig;
import com.dev.model.Speedelec;
import com.dev.service.BikeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BikeServiceImplTest {
    private static Speedelec speedelec;
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
    }

    @Test
    void addBikeServiceOk() {
        bikeService.add(speedelec);
        assertNotNull(speedelec.getId(), "Saved entity should have Id");
    }

    @Test
    void addListBikeServiceOk() {
        bikeService.addBikeList(List.of(speedelec));
        assertNotNull(speedelec.getId(), "Saved entity should have Id");
    }

    @Test
    void getBikeServiceOk() {
        bikeService.addBikeList(List.of(speedelec));
        assertEquals(bikeService.get(1L).get(), speedelec, "Saved entity should equals returned entity");
    }

    @Test
    void getAllBikeServiceOk() {
        assertEquals(bikeService.getAll().size(), 1, "Number of saved entities should be equal the number of returned entities");
    }

    @Test
    void deleteBikeServiceOk() {
        bikeService.addBikeList(List.of(speedelec));
        bikeService.delete(1L);
        assertEquals(bikeService.get(1L), Optional.empty(), "Entity should be removed from storage");
    }
}
