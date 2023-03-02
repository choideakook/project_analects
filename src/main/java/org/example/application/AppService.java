package org.example.application;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
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
        System.out.println("----------------------");
        List<App> apps = repository.findAll();
        List<App> list = new ArrayList<>();

        for (int i = apps.size() - 1; i >= 0; i--) {
            list.add(apps.get(i));
        }

        for (App app : list) {
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
            System.out.println(id + "번 명언은 존재하지 않습니다.");
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
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }

    //-- json save --//
    public void jsonSave() {
        List<App> findAll = repository.findAll();

        JSONArray jArray = new JSONArray();
        JSONObject result = new JSONObject();

        for (App app : findAll) {
            JSONObject obj = new JSONObject();
            obj.put("id", app.getId());
            obj.put("author", app.getAuthor());
            obj.put("saying", app.getSaying());
            jArray.add(obj);
        }

        result.put("result", jArray);

        try {
            FileWriter file = new FileWriter("/Users/choedaegug/Desktop/db/db.json");
            file.write(result.toString());
            file.flush();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //-- json load --//
    public void jsonLoad() {
        JSONParser parser = new JSONParser();

        try {
            FileReader reader = new FileReader("/Users/choedaegug/Desktop/db/db.json");
            Object obj = parser.parse(reader);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    //-- text save --//
    public void fileSave(File file) {
        List<App> findAll = repository.findAll();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (App app : findAll) {
                writer.write(String.valueOf("/" + app.getId()));
                writer.write("/" + app.getAuthor());
                writer.write("/" + app.getSaying() + "\n");
            }
            writer.close();
            System.out.println("파일이 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("저장에 실패했습니다.");
        }

    }

    //-- text load --//
    public void loadData(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String str;
            while ((str = reader.readLine()) != null) {
                String[] split = str.split("/");
                App app = App.createApp(split[3], split[2]);
                repository.sava(app);
            }

        } catch (FileNotFoundException e) {
            System.out.println("파일 읽기 실패");
        } catch (IOException e) {
            System.out.println("파일 읽기 실패");
        }
    }
}