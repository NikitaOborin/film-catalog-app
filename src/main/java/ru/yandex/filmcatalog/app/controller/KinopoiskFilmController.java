package ru.yandex.filmcatalog.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.filmcatalog.app.client.response.PagedFilmResponse;
import ru.yandex.filmcatalog.app.model.Film;
import ru.yandex.filmcatalog.app.model.FilmSearchCriteria;
import ru.yandex.filmcatalog.app.service.KinopoiskService;

import java.util.List;

@RequestMapping("/films")
@RestController
public class KinopoiskFilmController {
    private final KinopoiskService kinopoiskService;

    public KinopoiskFilmController(@Autowired KinopoiskService kinopoiskService) {
        this.kinopoiskService = kinopoiskService;
    }

    @GetMapping
    List<Film> getFilms() {
        return kinopoiskService.getFilms();
    }
}