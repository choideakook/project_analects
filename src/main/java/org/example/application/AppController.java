package org.example.application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Controller
 */
public class AppController {

    private final AppService service = new AppService();
    private String path = AppController.class.getResource("").getPath();

    //-- main logic controller --//
    public void startApp(File file, Scanner sc) {

        boolean loop = true;

        service.loadData(file);

        System.out.println("== 명언 앱 ==");

        while (loop) {
            System.out.print("명령) ");
            String command = sc.next();
            String[] order = orderMaker(command);

            switch (order[0]) {
                case "종료":
                    loop = false;
                    service.fileSave(file);
                    service.jsonSave();
                    break;
                case "등록":
                    service.register(sc);
                    break;
                case "목록":
                    service.listAll();
                    break;
                case "삭제":
                    try {
                        service.delete(sc, order[1]);
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("올바른 명령어를 입력해 주세요.");
                    }
                    break;
                case "수정":
                    try {
                        service.update(sc, order[1]);
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("올바른 명령어를 입력해 주세요.");
                    }
                    break;
                default:
                    System.out.println("올바른 명령어를 입력해 주세요.");
                    break;
            }
        }
    }

    //-- Command -> order --//
    private String[] orderMaker(String command) {
        String[] split = command.split("\\?", 2);
        return split;
    }

    //-- file controller --//
    public File textController() throws IOException {
        AppController controller = new AppController();
        File directory = new File("/Users/choedaegug/Desktop/db");

        controller.createDirectory(directory);
        System.out.println(directory.getPath());

        File file = new File(directory.getPath() + "/db1.txt");
        controller.createFile(file);
        return file;
    }

    //-- 파일 생성 --//
    private void createFile(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        } else {
            System.out.println("이미 파일이 존재합니다.");
        }
    }

    //-- 디렉토리 생성 --//
    private void createDirectory(File directory) {
        if (!directory.exists()) {
            boolean result = directory.mkdirs();
            System.out.println(result);
        } else {
            System.out.println("이미 디렉토리가 존재합니다.");
        }
    }
}
