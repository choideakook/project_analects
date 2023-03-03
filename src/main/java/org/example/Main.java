package org.example;

import org.example.application.AppController;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Application Start & Close
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //-- instance --//
        AppController controller = new AppController();
        Scanner sc = new Scanner(System.in);

        //-- business logic --//
        File file = controller.textController();
        controller.startApp(file, sc);

        //-- closing --//
        sc.close();

    }
}