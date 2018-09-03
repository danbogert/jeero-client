package com.yogurtpowered.jeero.command;

import com.yogurtpowered.jeero.response.NetworkResponse;
import com.yogurtpowered.jeero.response.RebootResponse;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

public class RebootCommand extends AbstractRestCommand<RebootResponse> {
    @Override
    public Optional<RebootResponse> execute() {
        Optional<NetworkResponse> network = new NetworkDetailsCommand().execute();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(API_BASE_URL)
                .path(network.get().getData().getResources().get("reboot"));

        return Optional.of(exchange(builder.toUriString(), HttpMethod.POST, RebootResponse.class));
    }
}
