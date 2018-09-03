package com.yogurtpowered.jeero;

import com.yogurtpowered.jeero.command.*;

public class JeeroClient {

    public JeeroClient() {
        new LoginCommand().execute();
    }

    public <T> T perform(Action action) {
        switch (action) {
            case GET_ACCOUNT_INFO:
                return (T) new AccountInfoCommand().execute();
            case GET_NETWORK_INFO:
                return (T) new NetworkDetailsCommand().execute();
            case GET_CLIENTS:
                return (T) new ClientsCommand().execute();
            case GET_DEVICES:
                return (T) new DevicesCommand().execute();
            case EXIT:
                return (T) new ExitCommand().execute();
            default:
                System.out.println("Unimplemented action: " + action);
                return null;
        }
    }
}
