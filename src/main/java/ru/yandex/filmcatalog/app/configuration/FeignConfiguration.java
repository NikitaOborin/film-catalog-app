package ru.yandex.filmcatalog.app.configuration;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 настройка api и feign клиентов
 */
@Configuration
@EnableFeignClients(basePackages = "ru.yandex.filmcatalog.app.client")
@EnableConfigurationProperties(KinopoiskApiProperties.class)
public class FeignConfiguration {

    private final KinopoiskApiProperties apiProperties;

    public FeignConfiguration(@Autowired KinopoiskApiProperties apiProperties) {
        this.apiProperties = apiProperties;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("X-API-KEY", apiProperties.getToken()); // здесь достаем токен
        };
    }
}