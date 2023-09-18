package ru.yandex.filmcatalog.app.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Film {
    String id = String.valueOf(UUID.randomUUID()); // id фильма внутри нашей БД
    String kinopoiskId; // внешний id external
    String localisationProperty;
    String name;

    public Film(String kinopoiskId, String localisationProperty, String name) {
        this.kinopoiskId = kinopoiskId;
        this.localisationProperty = localisationProperty;
        this.name = name;
    }
}
