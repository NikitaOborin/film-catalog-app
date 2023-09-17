package ru.yandex.filmcatalog.app.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class Film {
    String kinopoiskId;
    @JsonProperty("nameRu")
    String localisationProperty;
    @JsonProperty("nameOriginal")
    String name;
}
