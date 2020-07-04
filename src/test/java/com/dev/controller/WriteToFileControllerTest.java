package com.dev.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class WriteToFileControllerTest {
    private static final String FILE_PATH = "src/file.source/ecobike2.txt";
    private static File file;

    @BeforeEach
    void init() {
        file = new File(FILE_PATH);
    }

    @AfterEach
    void tearDown() {
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void loadFileOk() {
        WriteToFileController.writeToFile(FILE_PATH);
        assertTrue(file.exists(), "Saved file should exists");
    }
}