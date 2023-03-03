package org.example.application;

import org.junit.jupiter.api.Test;

class AppControllerTest {

    @Test
    void name() {

        System.out.println("시작");
        runBrake();
        System.out.println("종료");

    }

    private void runBrake() {
        System.out.println("브레이크 사지작");

    }
}