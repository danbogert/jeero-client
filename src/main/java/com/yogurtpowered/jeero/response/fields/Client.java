package com.yogurtpowered.jeero.response.fields;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class Client {
    private final String eui64;
    private final String hostname;
    private final String ip;
    private final String[] ips;
    private final String mac;

    public Client(@JsonProperty("eui64") String eui64,
                  @JsonProperty("hostname") String hostname,
                  @JsonProperty("ip") String ip,
                  @JsonProperty("ips") String[] ips,
                  @JsonProperty("mac") String mac) {
        this.eui64 = eui64;
        this.hostname = hostname;
        this.ip = ip;
        this.ips = ips;
        this.mac = mac;
    }

    public String getEui64() {
        return eui64;
    }

    public String getHostname() {
        return hostname;
    }

    public String getIp() {
        return ip;
    }

    public String[] getIps() {
        return ips;
    }

    public String getMac() {
        return mac;
    }

    @Override
    public String toString() {
        return "{" +
                "eui64='" + eui64 + '\'' +
                ", hostname='" + hostname + '\'' +
                ", ip='" + ip + '\'' +
                ", ips=" + Arrays.toString(ips) +
                ", mac='" + mac + '\'' +
                '}';
    }
}
