package com.dev;

import com.dev.controller.LoadFileController;
import com.dev.controller.MainMenuController;

class Application {
    private static final String FILE_PATH = "src/file.source/ecobike.txt";

    void start() {
        LoadFileController.loadFile(FILE_PATH);

        while (true) {
            MainMenuController.getMainMenuController();
        }
    }
}
