package ru.yandex.filmcatalog.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ru.yandex.filmcatalog.app.client.response.PagedFilmResponse;

@FeignClient(name = "kinopoiskClient", url = "https://kinopoiskapiunofficial.tech/api/v2.2")
public interface KinopoiskClient {
    @GetMapping("/films")
    PagedFilmResponse getFilms();
}
