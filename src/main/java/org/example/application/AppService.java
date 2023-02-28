package org.example.application;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AppService {

    AppRepository repository = new AppRepository();
    Scanner sc = new Scanner(System.in);
    public void register() {
        System.out.print("명언 : ");
        String saying = sc.next();
        System.out.print("작가 : ");
        String author = sc.next();

        App app = App.createApp(saying, author);
        Long appId = repository.sava(app);

        System.out.println(appId + " 번 명언이 등록되었습니다.");
    }

    public void listAll() {
        System.out.println("번호 / 작가 / 명언");
        List<App> apps = repository.findAll();

        for (App app : apps) {
            System.out.println(app.getId() + " / "
                    + app.getAuthor() + " / "
                    + app.getSaying());
        }
    }

    public void delete() {
        System.out.print("id = ");
        long id = sc.nextLong();

        App findApp = repository.findOne(id);

        try {
            repository.delete(findApp.getId());
            System.out.println(id + "번 명언이 삭제되었습니다.");
        } catch (NullPointerException e) {
            System.out.println(id +"번 명언은 존재하지 않습니다.");
        }
    }

    public void update() {
        System.out.print("id = ");
        long id = sc.nextLong();

        App findApp = repository.findOne(id);

        try {
            System.out.println("명언(기존) : " + findApp.getSaying());
            System.out.print("명언 : ");
            String saying = sc.next();

            System.out.println("작가(기존) : " + findApp.getAuthor());
            System.out.print("작가 : ");
            String author = sc.next();

            repository.update(id, saying, author);

            System.out.println(id + "번 명언이 변경 되었습니다.");
            System.out.println("번호 / 작가 / 명언");
            System.out.println(id + " / " + saying + " / " + author);

        } catch (NullPointerException e) {
            System.out.println(id +"번 명언은 존재하지 않습니다.");
        }
    }
}
