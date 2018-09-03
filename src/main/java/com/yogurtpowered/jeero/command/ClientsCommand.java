package com.yogurtpowered.jeero.command;

import com.yogurtpowered.jeero.response.ClientsResponse;
import com.yogurtpowered.jeero.response.NetworkResponse;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

public class ClientsCommand extends AbstractRestCommand<ClientsResponse> {
    @Override
    public Optional<ClientsResponse> execute() {
        Optional<NetworkResponse> network = new NetworkDetailsCommand().execute();
        if (!network.isPresent()) {
            return Optional.empty();
        }

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(API_BASE_URL)
                .path(network.get().getData().getClients().getUrl());

        return Optional.of(exchange(builder.toUriString(), HttpMethod.GET, ClientsResponse.class));
    }
}
