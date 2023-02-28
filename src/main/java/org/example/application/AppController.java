package org.example.application;

import java.util.Scanner;

public class AppController {

    AppService service = new AppService();



    public void startApp() {

        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        System.out.println("== 명언 앱 ==");

        while (loop) {
            System.out.print("명령) ");
            String command = sc.next();
            Long id = 0L;

            switch (command) {
                case "종료":
                    loop = false;
                    break;
                case "등록" :
                    service.register();
                    break;
                case "목록":
                    service.listAll();
                    break;
                case "삭제":
                    service.delete();
                    break;
                case "수정":
                    service.update();
                    break;
                default:
                    System.out.println("올바른 명령어를 입력해 주세요.");
                    break;
            }

        }

    }
}
