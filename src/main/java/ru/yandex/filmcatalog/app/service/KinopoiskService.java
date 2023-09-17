package ru.yandex.filmcatalog.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.filmcatalog.app.client.KinopoiskClient;
import ru.yandex.filmcatalog.app.client.response.PagedFilmResponse;

@Service
public class KinopoiskService {
    private final KinopoiskClient api;

    public KinopoiskService(@Autowired KinopoiskClient api) {
        this.api = api;
    }

    public PagedFilmResponse getFilms() {
        return api.getFilms();
    }
}