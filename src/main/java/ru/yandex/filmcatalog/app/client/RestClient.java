package ru.yandex.filmcatalog.app.client;

import ru.yandex.filmcatalog.app.client.response.PagedFilmResponse;

public interface RestClient {
    PagedFilmResponse getFilms();
}
