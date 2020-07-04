package com.dev.controller;

import com.dev.appconfig.AppConfig;
import com.dev.service.BikeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LoadFileControllerTest {
    private static final String FILE_PATH = "src/file.source/ecobike.txt";
    private static BikeService bikeService;

    @BeforeEach
    void init() {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        bikeService = context.getBean(BikeService.class);
    }

    @Test
    void loadFileOk() {
        LoadFileController.loadFile(FILE_PATH);
        assertNotNull(bikeService.getAll(), "Loaded entities from file should be loaded to storage");
    }
}
