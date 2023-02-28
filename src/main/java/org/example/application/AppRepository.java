package org.example.application;

import java.util.*;

public class AppRepository {

    private static Map<Long, App> store = new HashMap<>();
    private static Long sequence = 0L;

    //-- 저장 --//
    public Long sava(App app) {
        Long id = app.pk(++sequence);
        store.put(id, app);
        return app.getId();
    }

    //-- 전체 조회 --//
    public List<App> findAll() {
        ArrayList<App> apps = new ArrayList<>(store.values());
        return apps;
    }

    //-- 단건 조회 --//
    public App findOne(Long id) {

        return store.get(id);
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

    //-- test 용 로직 --//
    public void clearAll() {
        store.clear();
    }
}
