package com.dev.controller;

import com.dev.appconfig.AppConfig;
import com.dev.model.Bike;
import com.dev.service.BikeService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class WriteToFileController {
    static void writeToFile(String filePath) {
        Path path = Paths.get(filePath);
        List<Bike> bikes = readDataFromStorage();
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            for (Bike bike : bikes) {
                if (!bike.isLoadedFromFile())
                writer.write(bike.toString());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error while writing catalog to file");;
        }
        System.out.println("File successfully written! \n");
    }

    private static List<Bike> readDataFromStorage() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        BikeService bikeService = context.getBean(BikeService.class);
        return bikeService.getAll();
    }
}
