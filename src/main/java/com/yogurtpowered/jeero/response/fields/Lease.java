package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Lease {
    private final String mode;
    private final Dhcp dhcp;
    private final String statik;

    public Lease(@JsonProperty("mode") String mode,
                 @JsonProperty("dhcp") Dhcp dhcp,
                 @JsonProperty("statik") String statik) {
        this.mode = mode;
        this.dhcp = dhcp;
        this.statik = statik;
    }

    public String getMode() {
        return mode;
    }

    public Dhcp getDhcp() {
        return dhcp;
    }

    public String getStatik() {
        return statik;
    }

    @Override
    public String toString() {
        return "Lease{" +
                "mode='" + mode + '\'' +
                ", dhcp=" + dhcp +
                ", statik='" + statik + '\'' +
                '}';
    }
}
