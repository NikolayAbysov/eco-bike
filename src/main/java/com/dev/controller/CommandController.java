package com.dev.controller;

class CommandController {
    private static final String FILE_PATH = "src/file.source/ecobike.txt";

    void showCatalog() {
        ShowCatalogController.showCatalog();
    }

    void addNewFoldingBike() {
        AddNewFoldingBikeController.addNewFoldingBike();
    }

    void addNewSpeedelecBike() {
        AddNewSpeedelecBikeController.addNewSpeedelecBike();
    }

    void addNewElectricBike() {
        AddNewElectricBikeController.addNewElectricBike();
    }

    void findFirstItemParticularBrand() {
        FindFirstItemParticularBrandController.find();
    }

    void writeToFile() {
        WriteToFileController.writeToFile(FILE_PATH);
    }

    void stop() {
        System.exit(0);
    }
}
