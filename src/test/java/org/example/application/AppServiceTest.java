package org.example.application;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AppServiceTest {

    AppRepository repository = new AppRepository();

    @BeforeEach
    void beforeEach() {
        App app = App.createApp("aa", "bb");
        repository.sava(app);
    }

    @AfterEach
    void afterEach() {
        repository.clearAll();
    }

    @Test
    void save() {
        App app = App.createApp("aa", "bb");
        Long appId = repository.sava(app);

        App findApp = repository.findOne(appId);

        assertThat(findApp.getAuthor()).isEqualTo(app.getAuthor());
    }

    @Test
    void delete() {
        App findApp = repository.findOne(1L);

        Long delete = repository.delete(findApp.getId());

        App one = repository.findOne(delete);

        assertThatThrownBy(() -> one.getAuthor())
                .isInstanceOf(Exception.class);
    }

    @Test
    void update() {
        App findApp = repository.findOne(1L);

        App update = repository.update(findApp.getId(), "11", "22");

        assertThat(update.getAuthor()).isEqualTo("22");
        assertThat(update.getSaying()).isEqualTo("11");
    }
}