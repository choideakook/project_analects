package org.example.application;

/**
 * Entity
 */
public class App {

    //-- field --//
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

    private App() {}

    //-- 수정 로직 --//
    public void updateApp(String saying, String author) {
        this.saying = saying;
        this.author = author;
    }


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
