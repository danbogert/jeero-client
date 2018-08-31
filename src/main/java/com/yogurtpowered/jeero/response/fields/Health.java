package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Health {
    private final IspStatus internet;
    private final Status eeroNetwork;

    public Health(@JsonProperty("internet") IspStatus internet,
                  @JsonProperty("eero_network") Status eeroNetwork) {
        this.internet = internet;
        this.eeroNetwork = eeroNetwork;
    }

    public IspStatus getInternet() {
        return internet;
    }

    public Status getEeroNetwork() {
        return eeroNetwork;
    }

    @Override
    public String toString() {
        return "Health{" +
                "internet=" + internet +
                ", eeroNetwork=" + eeroNetwork +
                '}';
    }
}
