package ru.yandex.filmcatalog.app.repository;

import org.springframework.stereotype.Component;
import ru.yandex.filmcatalog.app.client.response.FilmResponse;
import ru.yandex.filmcatalog.app.erorr.exeption.DataBaseException;
import ru.yandex.filmcatalog.app.erorr.exeption.ErrorCode;
import ru.yandex.filmcatalog.app.model.Film;
import ru.yandex.filmcatalog.app.model.FilmSearchCriteria;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Component
public class InMemoryRepository implements Repository {
    Set<Film> memory = new HashSet<>(100);
    Set<FilmResponse> memoryResponse = new HashSet<>(100);
    @Override
    public FilmResponse save(FilmResponse filmResponse) {
        memoryResponse.add(filmResponse);
        return filmResponse;
    }

    @Override
    public Film save(Film film) {
        memory.add(film);
        return film;
    }

    @Override
    public Long saveAll(List<Film> films) {
        deleteAll();
        memory.addAll(films);
        return Long.valueOf(films.size());
    }

    @Override
    public List<Film> getFilms() {
        return streamOfFilms().toList();
    }

    @Override
    public Film getFilmById(String id) {
        return streamOfFilms()
                .filter(film -> film.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new DataBaseException(ErrorCode.NO_FILM_EXCEPTION.name())); // иначе выкинем эксепшн
    }

    @Override
    public List<Film> searchFilmByCriteria(FilmSearchCriteria filmSearchCriteria) {
        return streamOfFilms()
                .filter(film -> {
                    if(filmSearchCriteria.getKinopoiskId() != null) {
                        return film.getKinopoiskId().equals(filmSearchCriteria.getKinopoiskId());
                    } else {
                        return false;
                    }
                })
                .toList();
    }

    @Override
    public Long count() {
        return Long.valueOf(memory.size());
    }

    @Override
    public Long deleteAll() {
        Long deleted = Long.valueOf(memory.size());
        memory = new HashSet<>(100);
        return deleted;
    }

    private Stream<Film> streamOfFilms() {
        return memory.stream();
    }
}
