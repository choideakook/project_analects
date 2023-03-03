package org.example.application;

import java.util.*;

/**
 * Repository
 */
public class AppRepository {

    private static final Map<Long, App> store = new HashMap<>();
    private static Long sequence = 0L;

    //-- 저장 --//
    public Long sava(App app) {
        Long id = app.pk(++sequence);
        store.put(id, app);
        return app.getId();
    }

    //-- 삭제 --//
    public Long delete(Long id) {
        store.remove(id);
        return id;
    }

    //-- 수정 --//
    public App update(Long id, String saying, String author) {
        App findApp = store.get(id);
        findApp.updateApp(saying, author);
        return findApp;
    }

    //-- 전체 조회 --//
    public List<App> findAll() {
        ArrayList<App> apps = new ArrayList<>(store.values());
        return apps;
    }

    //-- id 로 조회 --//
    public App findOne(Long id) {
        App app = store.get(id);
        if (app == null) System.out.println(id + "번 명언은 존재하지 않습니다.");
        return app;
    }

    //-- 작가 이름으로 조회 --//
    public App findByName(String name) {
        List<App> list = new ArrayList<>();
        for (App value : store.values()) {
            if (value.getAuthor().equals(name)) list.add(value);
        }
        if (list.size() > 1){
            System.out.println("동일한 작가가 여러명 존재합니다.");
            return null;
        } else if (list.size() == 0) {
            System.out.println(name + "은 존재하지 않습니다.");
            return null;
        }
        return list.get(0);
    }

    //-- test 용 로직 --//
    public void clearAll() {
        store.clear();
    }
}
