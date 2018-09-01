package com.yogurtpowered.jeero.command;

import com.yogurtpowered.jeero.response.AccountResponse;
import com.yogurtpowered.jeero.response.NetworkResponse;
import com.yogurtpowered.jeero.response.fields.Networks;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpMethod;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.Optional;

public class NetworkDetailsCommandTest {
    private NetworkDetailsCommandStub command;

    @Test
    public void testExecute_noAccountInfo() {
        // Setup
        command = new NetworkDetailsCommandStub(null);

        // Test
        Optional<NetworkResponse> response = command.execute();

        // Verify
        Assert.assertFalse(response.isPresent());
    }

    @Test
    public void testExecute_nullNetworks() {
        // Setup
        AccountResponse account = getAccount(null);
        command = new NetworkDetailsCommandStub(account);

        // Test
        Optional<NetworkResponse> response = command.execute();

        // Verify
        Assert.assertFalse(response.isPresent());
    }

    @Test
    public void testExecute_noNetworks() {
        // Setup
        AccountResponse account = getAccount(getNetworks());
        command = new NetworkDetailsCommandStub(account);

        // Test
        Optional<NetworkResponse> response = command.execute();

        // Verify
        Assert.assertFalse(response.isPresent());
    }

    @Test
    public void testExecute_oneNetworks() {
        // Setup
        AccountResponse account = getAccount(getNetworks("/network0"));
        command = new NetworkDetailsCommandStub(account);

        // Test
        Optional<NetworkResponse> response = command.execute();

        // Verify
        Assert.assertTrue(response.isPresent());
        Assert.assertEquals("https://api-user.e2ro.com/network0", response.get().getData().getUrl());
    }

    @Test
    public void testExecute_twoNetworks() {
        // Setup
        AccountResponse account = getAccount(getNetworks("/network0", "/network1"));
        command = new NetworkDetailsCommandStub(account);
        System.setIn(new ByteArrayInputStream("1".getBytes()));

        // Test
        Optional<NetworkResponse> response = command.execute();

        // Verify
        Assert.assertTrue(response.isPresent());
        Assert.assertEquals("https://api-user.e2ro.com/network1", response.get().getData().getUrl());
    }

    private AccountResponse getAccount(Networks networks) {
        AccountResponse.AccountData accountData = new AccountResponse.AccountData(
            null,
            null,
            null,
            null,
            null,
                networks,
            null,
            false,
            null,
            null,
            null);
        return new AccountResponse(null, accountData);
    }

    private Networks getNetworks(String... urls) {
        Networks.Network[] n = new Networks.Network[urls.length];

        for (int i = 0; i < urls.length; i++) {
            n[i] = new Networks.Network(urls[i], "network_" + i, new Date());
        }

        return new Networks(urls.length, n);
    }

    private class NetworkDetailsCommandStub extends NetworkDetailsCommand {
        private final AccountResponse account;

        public NetworkDetailsCommandStub(AccountResponse account) {
            this.account = account;
        }

        @Override
        protected Optional<AccountResponse> getAccountInfo() {
            return Optional.ofNullable(account);
        }

        @Override
        protected <T> T exchange(String uriString, HttpMethod httpMethod, Class<T> responseClazz) {
            NetworkResponse.NetworkData data = new NetworkResponse.NetworkData(
                    uriString,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    false,
                    false,
                    false,
                    false,
                    false,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null);

            return (T) new NetworkResponse(null, data);
        }
    }
}
