package ru.yandex.filmcatalog.app.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PagedFilmResponse {
    @JsonProperty
    List<Film> items;
    Integer total;
    Integer totalPages;
}
