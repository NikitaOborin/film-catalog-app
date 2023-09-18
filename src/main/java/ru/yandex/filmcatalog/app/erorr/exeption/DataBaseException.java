package ru.yandex.filmcatalog.app.erorr.exeption;

public class DataBaseException extends RuntimeException {
    public DataBaseException(String message) {
        super(message);
    }
}
