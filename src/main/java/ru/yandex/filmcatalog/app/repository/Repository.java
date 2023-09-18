package ru.yandex.filmcatalog.app.repository;

import org.springframework.stereotype.Component;
import ru.yandex.filmcatalog.app.client.response.FilmResponse;
import ru.yandex.filmcatalog.app.model.Film;
import ru.yandex.filmcatalog.app.model.FilmSearchCriteria;

import java.util.List;

public interface  Repository {
    FilmResponse save(FilmResponse filmResponse); // так делать не надо, нарушение MVC, просто для демонстрации
    Film save(Film film);
    Long saveAll(List<Film> films);
    List<Film> getFilms();
    Film getFilmById(String id);
    List<Film> searchFilmByCriteria(FilmSearchCriteria filmSearchCriteria);
    Long count();
    Long deleteAll();
}
