package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dhcp {
    private final String ip;
    private final String mask;
    private final String router;

    public Dhcp(@JsonProperty("ip") String ip,
                @JsonProperty("mask") String mask,
                @JsonProperty("router") String router) {
        this.ip = ip;
        this.mask = mask;
        this.router = router;
    }

    public String getIp() {
        return ip;
    }

    public String getMask() {
        return mask;
    }

    public String getRouter() {
        return router;
    }

    @Override
    public String toString() {
        return "Dhcp{" +
                "ip='" + ip + '\'' +
                ", mask='" + mask + '\'' +
                ", router='" + router + '\'' +
                '}';
    }
}
