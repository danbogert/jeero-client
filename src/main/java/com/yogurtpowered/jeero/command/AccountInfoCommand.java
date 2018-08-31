package com.yogurtpowered.jeero.command;

import com.yogurtpowered.jeero.response.AccountResponse;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

public class AccountInfoCommand extends AbstractRestCommand<AccountResponse> {
    private static final String ACCOUNT_PATH = "/2.2/account";

    @Override
    public Optional<AccountResponse> execute() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(API_BASE_URL)
                .path(ACCOUNT_PATH);

        return Optional.of(exchange(builder.toUriString(), HttpMethod.GET, AccountResponse.class));
    }
}
