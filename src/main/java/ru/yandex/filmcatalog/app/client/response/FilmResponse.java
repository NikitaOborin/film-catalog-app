package ru.yandex.filmcatalog.app.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class FilmResponse {
    String kinopoiskId;
    @JsonProperty("nameRu")
    String localisationName;
    @JsonProperty("nameOriginal")
    String name;
}
