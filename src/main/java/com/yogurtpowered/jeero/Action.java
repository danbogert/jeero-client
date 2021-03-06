package com.yogurtpowered.jeero;

public enum Action {
    GET_ACCOUNT_INFO("Get Account Info"),
    GET_NETWORK_INFO("Get Network Info"),
    GET_CLIENTS("Get Clients"),
    GET_DEVICES("Get Devices"),
    REBOOT("Reboot Network"),
    EXIT("Exit");

    private final String displayName;

    Action(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
