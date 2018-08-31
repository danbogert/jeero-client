package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PushSettings {
    private final boolean networkOffline;
    private final boolean nodeOffline;

    public PushSettings(
            @JsonProperty("networkOffline") boolean networkOffline,
            @JsonProperty("nodeOffline") boolean nodeOffline) {
        this.networkOffline = networkOffline;
        this.nodeOffline = nodeOffline;
    }

    public boolean isNetworkOffline() {
        return networkOffline;
    }

    public boolean isNodeOffline() {
        return nodeOffline;
    }

    @Override
    public String toString() {
        return "{" +
                "\n\t\tnetworkOffline=" + networkOffline +
                "\n\t\tnodeOffline=" + nodeOffline +
                '}';
    }
}
