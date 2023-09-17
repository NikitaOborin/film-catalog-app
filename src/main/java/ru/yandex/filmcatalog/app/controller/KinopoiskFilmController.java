package ru.yandex.filmcatalog.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.filmcatalog.app.client.response.PagedFilmResponse;
import ru.yandex.filmcatalog.app.service.KinopoiskService;

@RequestMapping("/films")
@RestController
public class KinopoiskFilmController {
    private final KinopoiskService kinopoiskService;

    public KinopoiskFilmController(KinopoiskService kinopoiskService) {
        this.kinopoiskService = kinopoiskService;
    }

    @GetMapping
    PagedFilmResponse getFilms() {
        return kinopoiskService.getFilms();
    }
}
