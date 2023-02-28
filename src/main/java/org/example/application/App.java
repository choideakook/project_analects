package org.example.application;

public class App {

    private Long id;

    private String saying;
    private String author;

    //-- 생성자 --//
    public static App createApp( String saying, String author) {
        App app = new App();
        app.saying = saying;
        app.author = author;
        return app;
    }

    public Long pk(Long id) {
        this.id = id;
        return id;
    }

    //-- 수정 로직 --//
    public void updateApp(String saying, String author) {
        this.saying = saying;
        this.author = author;
    }

    protected App() {}

    //-- getter  --//


    public Long getId() {
        return id;
    }

    public String getSaying() {
        return saying;
    }

    public String getAuthor() {
        return author;
    }
}
