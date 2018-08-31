package com.yogurtpowered.jeero.command;

import com.yogurtpowered.jeero.response.NetworkResponse;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

public class ClientsCommand extends AbstractRestCommand<String> {
    private static final String CLIENTS_PATH = "/clients";
    @Override
    public Optional<String> execute() {
        Optional<NetworkResponse> network = new NetworkDetailsCommand().execute();
        if (!network.isPresent()) {
            return Optional.empty();
        }

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(API_BASE_URL)
                .path(network.get().getData().getUrl())
                .path(CLIENTS_PATH);

        return Optional.of(exchange(builder.toUriString(), HttpMethod.GET, String.class));
    }
}
