package org.example.application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AppController {

    AppService service = new AppService();
    Scanner sc = new Scanner(System.in);

    private String path = AppController.class.getResource("").getPath();

    //-- main logic controller --//
    public void startApp(File file) {

        boolean loop = true;

        service.loadData(file);

        System.out.println("== 명언 앱 ==");

        while (loop) {
            System.out.print("명령) ");
            String command = sc.next();
            Long id = 0L;

            switch (command) {
                case "종료":
                    loop = false;
                    service.fileSave(file);
                    break;
                case "등록":
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
        sc.close();
    }

    //-- file save controller --//
    public File tester() throws IOException {
        AppController controller = new AppController();
        File directory = new File("/Users/choedaegug/Desktop/db");

        controller.createDirectory(directory);
        System.out.println(directory.getPath());

        File file = new File(directory.getPath() + "/db1.txt");
        controller.createFile(file);
        return file;
    }

    private void createFile(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        } else {
            System.out.println("이미 파일이 존재합니다.");
        }
    }

    private void createDirectory(File directory) {
        if (!directory.exists()) {
            boolean result = directory.mkdirs();
            System.out.println(result);
        } else {
            System.out.println("이미 디렉토리가 존재합니다.");
        }
    }
}
