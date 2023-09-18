package ru.yandex.filmcatalog.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.yandex.filmcatalog.app.client.KinopoiskClient;
import ru.yandex.filmcatalog.app.client.RestClient;
import ru.yandex.filmcatalog.app.client.response.PagedFilmResponse;
import ru.yandex.filmcatalog.app.model.Film;
import ru.yandex.filmcatalog.app.repository.Repository;

import java.util.List;

@Service
public class KinopoiskService {
    private final RestClient api;

    @Autowired
    @Qualifier("inMemoryRepository")
    private Repository inMemoryRepository;

    public KinopoiskService(@Autowired KinopoiskClient api) {
        this.api = api;
    }

    public List<Film> getFilms() {
        if (inMemoryRepository.count().equals(0L)) { //берем фильмы из api, но только в том случае ...
            PagedFilmResponse pagedFilmResponse = api.getFilms();
            return pagedFilmResponse.getItems().stream().map(filmResponse -> // важно, чтобы в дальнейшем не использовать filmResponse, а переходить на доменные объекты
                    new Film(filmResponse.getKinopoiskId(), filmResponse.getLocalisationName(), filmResponse.getName())) // здесь перемаппим в доменный объект Film, так правильнее работать с MVC
                    .map(inMemoryRepository::save) // для каждого элемента вызываем метод у репозитория (ссылка на метод)
                    .toList();
        } else {
            return inMemoryRepository.getFilms();
        }
    }
}