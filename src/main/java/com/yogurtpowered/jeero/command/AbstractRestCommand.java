package com.yogurtpowered.jeero.command;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

public abstract class AbstractRestCommand<T> implements Command<T> {
    protected static final String API_BASE_URL = "https://api-user.e2ro.com";
    protected static final RestTemplate REST_TEMPLATE = new RestTemplate();
    protected static final HttpHeaders HTTP_HEADERS = new HttpHeaders();

    protected <T> T exchange(String uriString, HttpMethod httpMethod, Class<T> responseClazz) {
        System.out.println(httpMethod + ": " + uriString);

        ResponseEntity<T> response = REST_TEMPLATE.exchange(
                uriString,
                httpMethod,
                new HttpEntity<>(HTTP_HEADERS),
                responseClazz);

        return response.getBody();
    }

    public abstract Optional<T> execute();
}
