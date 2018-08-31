package com.yogurtpowered.jeero.command;

import com.yogurtpowered.jeero.utils.InputHelper;
import com.yogurtpowered.jeero.response.AccountResponse;
import com.yogurtpowered.jeero.response.NetworkResponse;
import com.yogurtpowered.jeero.response.fields.Networks;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

public class NetworkDetailsCommand extends AbstractRestCommand<NetworkResponse> {
    @Override
    public Optional<NetworkResponse> execute() {
        Optional<AccountResponse> account = getAccountInfo();
        if (!account.isPresent() || account.get().getData() == null || account.get().getData().getNetworks() == null) {
            return Optional.empty();
        }

        Networks.Network network = determineNetwork(account.get().getData().getNetworks().getNetworks());
        if (network == null) {
            return Optional.empty();
        }

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(API_BASE_URL)
                .path(network.getUrl());
        return Optional.of(exchange(builder.toUriString(), HttpMethod.GET, NetworkResponse.class));
    }

    protected Optional<AccountResponse> getAccountInfo() {
        return new AccountInfoCommand().execute();
    }

    private Networks.Network determineNetwork(Networks.Network[] networks) {
        if (networks == null || networks.length == 0) {
            return null;
        }

        if (networks.length == 1) {
            return networks[0];
        }

        System.out.println("Multiple networks are available, which would you like the info for?");
        for (int i = 0; i < networks.length; i++) {
            System.out.println(i + ") " + networks[i].getUrl());
        }

        int choice = InputHelper.getInt(SCANNER, "Which would you like the info for? ", 0, networks.length - 1);
        return networks[choice];
    }
}
