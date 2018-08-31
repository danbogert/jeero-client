package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IpSettings {
    private final boolean doubleNat;
    private final String publicIp;

    public IpSettings(@JsonProperty("double_nat") boolean doubleNat,
                      @JsonProperty("public_ip") String publicIp) {
        this.doubleNat = doubleNat;
        this.publicIp = publicIp;
    }

    public boolean isDoubleNat() {
        return doubleNat;
    }

    public String getPublicIp() {
        return publicIp;
    }

    @Override
    public String toString() {
        return "IpSettings{" +
                "doubleNat=" + doubleNat +
                ", publicIp='" + publicIp + '\'' +
                '}';
    }
}
