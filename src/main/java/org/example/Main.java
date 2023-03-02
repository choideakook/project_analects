package org.example;

import org.example.application.AppController;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AppController controller = new AppController();

        File file = controller.tester();

        controller.startApp(file);

    }
}